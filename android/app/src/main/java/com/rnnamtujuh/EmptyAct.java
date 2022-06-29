package com.rnnamtujuh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class EmptyAct extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sec);
    Button button = (Button)findViewById(R.id.button);

    MainApplication application = (MainApplication) this.getApplication();

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
    });
  }
}