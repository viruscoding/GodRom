#!/bin/bash

#set -ex
cpus=$(grep ^processor /proc/cpuinfo | wc -l)
threads=$((cpus * 2))

## build kernel
export PATH=$PATH:$(pwd)/prebuilts/gcc/linux-x86/aarch64/aarch64-linux-android-4.9/bin
## 谷歌在Android Pie上为32位用户空间添加了一个新的compat vDSO ，这需要一个32位的工具链 因此，如果未设置CROSS_COMPILE_ARM32，则构建将出错。
export  CROSS_COMPILE_ARM32=$(pwd)/prebuilts/gcc/linux-x86/arm/arm-linux-androideabi-4.9/bin/arm-linux-androideabi-
cd ./msm &&
export ARCH=arm64 &&
export CROSS_COMPILE=aarch64-linux-android- &&
# make bullhead_defconfig
make marlin_defconfig &&
make -j $threads &&

## build boot image
cd .. &&
source build/envsetup.sh &&
lunch aosp_sailfish-userdebug &&
## set kernel path
export TARGET_PREBUILT_KERNEL=$(pwd)/msm/arch/arm64/boot/Image.lz4-dtb
rm out/target/product/sailfish/kernel out/target/product/sailfish/boot.img
make bootimage -j $threads
rm ./msm/arch/arm64/boot/Image.lz4-dtb
