#!/bin/bash

#set -ex

cpus=$(grep ^processor /proc/cpuinfo | wc -l)

source build/envsetup.sh &&
lunch aosp_sailfish-userdebug &&

threads=$((cpus * 2)) &&
make -j $threads
