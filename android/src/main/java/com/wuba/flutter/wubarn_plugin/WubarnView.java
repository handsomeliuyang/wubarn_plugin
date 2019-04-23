package com.wuba.flutter.wubarn_plugin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;

public class WubarnView implements PlatformView, MethodChannel.MethodCallHandler{
    private final ReactRootView mReactRootView;
    private final ReactInstanceManager mReactInstanceManager;

//    private final Activity mActivity;

    public WubarnView(Context context, BinaryMessenger messenger, int id) {
        MethodChannel methodChannel = new MethodChannel(messenger, WubarnPlugin.VIEW_TYPE + "_" + id);
        methodChannel.setMethodCallHandler(this);

//        mActivity = (Activity)context;
        mReactRootView = new ReactRootView(context);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication((Application) context.getApplicationContext())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(false)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        // 这个"App1"名字一定要和我们在index.js中注册的名字保持一致AppRegistry.registerComponent()
        mReactRootView.startReactApplication(mReactInstanceManager, "App1", null);
    }

    @Override
    public View getView() {
        return mReactRootView;
    }

    @Override
    public void dispose() {
//        mReactInstanceManager.onHostPause(mActivity);
//        mReactInstanceManager.onHostResume(mActivity, null);
//        mReactInstanceManager.onHostDestroy(mActivity);
        mReactRootView.unmountReactApplication();
    }

    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        switch (methodCall.method){
            case "":
                break;
            default:
                result.notImplemented();
        }
    }
}
