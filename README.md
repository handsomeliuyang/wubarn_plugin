# wubarn_plugin

在Flutter里，嵌入ReactNative View的Plugin

# 使用

1. 在android的gradle编译文件里，添加如下配置，保证生成后的apk，只保留armeabi-v7a
    ```gradle
    buildTypes {
        debug {
            ...
            ndk {
                abiFilters "armeabi-v7a"
            }
        }
        release {
            ...
            ndk {
                abiFilters "armeabi-v7a"
            }
        }
    }
    ```
2. debug运行Flutter程序时，添加平台标记：
    ```shell
    flutter run --target-platform android-arm
    ```
