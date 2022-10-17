package com.god.godmanager.Common;

import android.app.IGodRom;
import android.os.IBinder;
import android.util.Log;


import java.lang.reflect.Method;

public class ServiceUtils {
    private static IGodRom iGodRom = null;
    public static IGodRom getiGodRom() {
        if (iGodRom == null) {
            try {
                Class localClass = Class.forName("android.os.ServiceManager");
                Method getService = localClass.getMethod("getService", new Class[] {String.class});
                if(getService != null) {
                    Object objResult = getService.invoke(localClass, new Object[]{"godrom"});
                    if (objResult != null) {
                        IBinder binder = (IBinder) objResult;
                        iGodRom = IGodRom.Stub.asInterface(binder);
                    }
                }
            } catch (Exception e) {
                Log.d("GodManager",e.getMessage());
                e.printStackTrace();
            }
        }
        return iGodRom;
    }
}
