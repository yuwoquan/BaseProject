package com.example.baseproject.utils.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.HashMap;


public class PermissionManager {

    private final String TAG = getClass().getName();

    private static PermissionManager instance;

    // all needed permission in the app
    private static HashMap<String, Integer> permissionBeans;

    private PermissionManager() {

        permissionBeans = new HashMap<>();
        String[] perms = new String[]{
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE};

        for (String s :
                perms) {
            permissionBeans.put(s, 2);
        }

    }

    public static PermissionManager getInstance() {
        if (instance == null) {
            instance = new PermissionManager();
        }
        return instance;
    }

    public HashMap<String, Integer> getPermissionBeans() {
        return permissionBeans;
    }

    public void setPermissionBeans(HashMap<String, Integer> permissionBeans) {
        PermissionManager.permissionBeans = permissionBeans;
    }

    public boolean isAllAllowed() {

        for (int permissionstate : permissionBeans.values()
                ) {
            if (permissionstate == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }

        return true;
    }

    public void checkPermission(Context context, int requestCode) {
        if (permissionBeans != null) {

            StringBuilder permissonBuilder = new StringBuilder();

            for (String per :
                    permissionBeans.keySet()) {
                if (ContextCompat.checkSelfPermission(context, per) !=
                        PackageManager.PERMISSION_GRANTED) {
                    permissionBeans.put(per, PackageManager.PERMISSION_DENIED);
                    permissonBuilder.append(per);
                    permissonBuilder.append(",");
                } else {
                    permissionBeans.put(per, PackageManager.PERMISSION_GRANTED);
                }
            }

            String pers = new String(permissonBuilder);
            if (pers.length() > 1) {
                pers = pers.substring(0, pers.length() - 1);
                if (pers.length() > 0) {
                    String[] perArray;
                    if (pers.contains(",")) {
                        perArray = pers.split(",");
                    } else {
                        perArray = new String[]{pers};
                    }
                    ActivityCompat.requestPermissions((Activity) context, perArray, requestCode);
                }
            }
        }
    }
}
