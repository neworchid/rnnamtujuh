package com.rnnamtujuh;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class CalendarModule extends ReactContextBaseJavaModule {
  CalendarModule(ReactApplicationContext context) {
    super(context);
  }

  @NonNull
  @Override
  public String getName() {
    return "CalendarModule";
  }

  @ReactMethod
  public void createCalendarEvent(String name, String location) {
    Log.d("CalendarModule", "Create event called with name: " + name + " and location: " + location);
    Context context = this.getReactApplicationContext();
    Intent intent = new Intent(context, EmptyAct.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);

    /*long start = System.currentTimeMillis();
    long end = start + 3000;
    while (true) {
      //do your code
      //
      WritableMap params = Arguments.createMap();
      params.putString("eventProperty", "someValue");
      ((ReactApplicationContext) context).getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
          .emit("EVENT_REMINDER", params);
      if (System.currentTimeMillis() > end) {
        break;
      }
    }*/

  }
}
