package com.rnnamtujuh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.react.PackageList;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.soloader.SoLoader;

import java.util.List;

public class EmptyAct extends ReactActivity {
  private ReactRootView mReactRootView;
  private ReactInstanceManager mReactInstanceManager;
/*
  @Nullable
  @Override
  protected String getMainComponentName() {
    return "rnnamtujuh";
  }*/

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.sec);
    /*SoLoader.init(this, false);
    Button button = (Button)findViewById(R.id.button);
    mReactRootView = new ReactRootView(this);
    List<ReactPackage> packages = new PackageList(getApplication()).getPackages();
    // Packages that cannot be autolinked yet can be added manually here, for example:
    // packages.add(new MyReactNativePackage());
    // Remember to include them in `settings.gradle` and `app/build.gradle` too.

    mReactInstanceManager = ReactInstanceManager.builder()
        .setApplication(getApplication())
        .setCurrentActivity(this)
        .setBundleAssetName("index.android.bundle")
        .setJSMainModulePath("index")
        .addPackages(packages)
        .setUseDeveloperSupport(BuildConfig.DEBUG)
        .setInitialLifecycleState(LifecycleState.RESUMED)
        .build();
    // The string here (e.g. "IntegratedApp") has to match
    // the string in AppRegistry.registerComponent() in index.js
    mReactRootView.startReactApplication(mReactInstanceManager, "IntegratedApp", null);*/
    /*SoLoader.init(this, false);
    MainApplication application = (MainApplication) this.getApplication();
    ReactNativeHost reactNativeHost = application.getReactNativeHost();
    reactNativeHost.getReactInstanceManager().getViewManagerNames();
    mReactRootView = new ReactRootView(this);
    mReactRootView.startReactApplication(reactNativeHost.getReactInstanceManager(), "rnnamtujuh", null);
    setContentView(mReactRootView);*/
    setContentView(new MyCustomView(this, null));

   /* MainApplication application = (MainApplication) this.getApplication();

    ReactNativeHost reactNativeHost = application.getReactNativeHost();
    ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
    ReactContext reactContext = reactInstanceManager.getCurrentReactContext();
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        WritableMap params = Arguments.createMap();
        params.putString("eventProperty", "someValue");


        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit("EVENT_REMINDER", params);
      }
    });*/
  }
  public class MyCustomView extends LinearLayout {
    public MyCustomView(Context context, AttributeSet attrs)
    {
      super(context, attrs);

      setOrientation(LinearLayout.VERTICAL);
      setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

      TextView tv1 = new TextView(context);
      tv1.setText("HELLO");
      addView(tv1);

      TextView tv2 = new TextView(context);
      tv2.setText("WORLD");
      SoLoader.init(context, false);
      MainApplication application = (MainApplication) EmptyAct.this.getApplication();
      ReactNativeHost reactNativeHost = application.getReactNativeHost();
      reactNativeHost.getReactInstanceManager().getViewManagerNames();
      mReactRootView = new ReactRootView(context);
      mReactRootView.startReactApplication(reactNativeHost.getReactInstanceManager(), "rnnamtujuh", null);
      ReactRootView xview = new ReactRootView(context);
      xview.startReactApplication(reactNativeHost.getReactInstanceManager(),"xview", null);
      setContentView(mReactRootView);
      addView(xview);
      addView(tv2);

    }
  }
}