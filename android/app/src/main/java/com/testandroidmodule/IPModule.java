package com.testandroidmodule;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IPModule extends ReactContextBaseJavaModule {

    private static ReactApplicationContext reactContext;

    IPModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @ReactMethod
    public void getIP(Promise promise){
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        promise.resolve(inetAddress.getHostAddress());
                    }
                }
            }

        } catch (Exception ex) {
            promise.reject("Error", ex);
        }
    }

    @ReactMethod
    public void toastNative(String text){
        Toast.makeText(reactContext, text, Toast.LENGTH_LONG).show();
    }



    @NonNull
    @Override
    public String getName() {
        return "IPModule";
    }
}
