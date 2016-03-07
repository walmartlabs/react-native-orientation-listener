package com.walmartreact.ReactOrientationListener;

import javax.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.content.Context;
import android.hardware.SensorManager;
import android.view.OrientationEventListener;
import android.os.Build;

import java.util.HashMap;
import java.util.Map;

public class ReactOrientationListenerModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;
  OrientationEventListener mOrientationListener;

  public ReactOrientationListenerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    final ReactApplicationContext thisContext = reactContext;

    mOrientationListener = new OrientationEventListener(reactContext,
      SensorManager.SENSOR_DELAY_NORMAL) {
      @Override
      public void onOrientationChanged(int orientation) {
        WritableNativeMap params = new WritableNativeMap();
        String orientationValue = "";
        if(orientation == 0) {
          orientationValue = "PORTRAIT";
        } else {
          orientationValue = "LANDSCAPE";
        }
        params.putString("orientation", orientationValue);
        params.putString("device", getDeviceName());
        if (thisContext.hasActiveCatalystInstance()) {
          thisContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit("orientationDidChange", params);
        }
      }
    };

    if (mOrientationListener.canDetectOrientation() == true) {
      mOrientationListener.enable();
    } else {
      mOrientationListener.disable();
    }
  }

  public String getDeviceName() {
    String manufacturer = Build.MANUFACTURER;
    String model = Build.MODEL;
    if (model.startsWith(manufacturer)) {
      return capitalize(model);
    } else {
      return capitalize(manufacturer) + " " + model;
    }
  }

  private String capitalize(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    char first = s.charAt(0);
    if (Character.isUpperCase(first)) {
      return s;
    } else {
      return Character.toUpperCase(first) + s.substring(1);
    }
  }

  @Override
  public String getName() {
    return "OrientationListener";
  }

  @Override
  public @Nullable Map<String, Object> getConstants() {
    HashMap<String, Object> constants = new HashMap<String, Object>();
    PackageManager packageManager = this.reactContext.getPackageManager();
    String packageName = this.reactContext.getPackageName();
    return constants;
  }

  @ReactMethod
  public void getOrientation(Callback success) {
    WritableNativeMap data = new WritableNativeMap();
    DisplayMetrics metrics = this.reactContext.getResources().getDisplayMetrics();
    String orientation = "";
    if(metrics.widthPixels < metrics.heightPixels){
      orientation = "PORTRAIT";
    }else {
      orientation = "LANDSCAPE";
    }
    data.putString("orientation", orientation);
    data.putString("device", getDeviceName());
    success.invoke(data);
  }

}
