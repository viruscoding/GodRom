zip -j update.zip out/target/product/sailfish/system.img out/target/product/sailfish/system_other.img out/target/product/sailfish/boot.img out/target/product/sailfish/vendor.img out/target/product/sailfish/android-info.txt
fastboot -w update update.zip
rm update.zip
