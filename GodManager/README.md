# GodManager

### 简介

GodManager 是一个 rom 逆向工具的管理界面。该软件用于对接 GodRom 来实现 rom 层面的逆向工具。仅仅提供界面化操作管理，并将用户需求保存为 json 数据，由 GodRom 解析后进行相应的执行，并导出结果到对应的目录。

### 配套 ROM

> https://github.com/dqzg12300/GodRom

### 调整说明

ROM 从 PixelExperience 调整为 aosp10，后续如果有更新，不再维护 PixelExperience 版本

新增全局配置可以修改为默认使用 frida14 的 gadget（仅支持 aosp 版本的）

新增 io 重定向功能 （对应 godrom_1.0.2 版本，暂未放出对应 ROM 下载）

### 提示

> 所有需要选择的文件都要放在对应目标的 sdcard 目录中，路径是`/sdcard/Android/data/<PackageName>`。
> 脱壳的 dump 结果会保存在`/sdcard/Android/data/<PackageName>/files/dump/`目录，有些 app 会缺少 files 这个目录，需要自己手动创建一下。

### 目录说明

`/sdcard/Android/data/<PackageName>/files/dump`该目录存放脱壳的结果，脱壳成功会生成对应的包名目录

`/sdcard/Android/data/<PackageName>/files/dump/<size>_classlist.txt`:脱壳应用的类列表

`/sdcard/Android/data/<PackageName>/files/dump/<size>_classlist_execute.txt`execute 的触发时机获取的类列表

`/sdcard/Android/data/<PackageName>/files/dump/<size>_dexfile.dex`脱壳结果

`/sdcard/Android/data/<PackageName>/files/dump/<size>_deep_dexfile.dex`:更深调用的脱壳结果

`/sdcard/Android/data/<PackageName>/files/dump/<size>_dexfile_repair.dex`修复后的脱壳结果

### 功能

> - 内核修改过反调试
> - 开启硬件断点
> - 自动弹出 USB 调试
> - 脱壳（黑名单、白名单过滤、更深的主动调用链）
> - ROM 打桩（ArtMethod 调用、RegisterNative 调用、JNI 函数调用）
> - frida 持久化（支持 listen,wait,script 三种模式）
> - 反调试（通过 sleep 目标函数，再附加进程来过掉起始的反调试）
> - trace java 函数（smali 指令的 trace）
> - 内置 dobby 注入
> - 支持自行切换 frida-gadget 版本
> - 注入 so
> - 注入 dex（实现对应的接口触发调用。目前未完成）

### 更新说明

> - 优化可以控制是否打开 debuggable，该功能对应 lineageOS 版本 GodRom，这个选项修改后，需要重新安装 app 生效。

### 附录

该项目仅为个人练手作品，非商业项目。开源仅供学习，请勿用于非法用途。

### 感谢

> [FridaManager](https://github.com/hanbinglengyue/FridaManager)
>
> [FART](https://github.com/hanbinglengyue/FART)

### 界面展示

![](./godmanager.gif)

### 原理

[FartExt 超进化之奇奇怪怪的新 ROM 工具 GodRom](https://bbs.pediy.com/thread-271358.htm)
