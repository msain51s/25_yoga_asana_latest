package com.yoga_asana.utility;

import android.content.Context;

import com.google.android.gms.ads.MobileAds;
import com.yoga_asana.R;

/**
 * Created by Administrator on 11/28/2016.
 */
public class Application extends android.app.Application {
    private static Application ourInstance = new Application();
    public static Context mContext;

    public static Application getInstance() {
        return ourInstance;
    }

    public Application() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        MobileAds.initialize(this, getString(R.string.admob_app_id));
    }
}
