package com.yoga_asana.utility;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Administrator on 8/30/2017.
 */

public class Utils {

    public static Typeface getCustomFont(Context context, int type){
        Typeface typeface=null;
        if(type==FontType.ROBOTO_LIGHT)
            typeface=Typeface.createFromAsset(Application.mContext.getAssets(), "fonts/Roboto-Light.ttf");
        else if(type==FontType.ROBOTO_THIN_ITALIC)
            typeface= Typeface.createFromAsset(Application.mContext.getAssets(), "fonts/Roboto-ThinItalic.ttf");
        else if(type==FontType.ROBOTO_THIN)
            typeface= Typeface.createFromAsset(Application.mContext.getAssets(), "fonts/Roboto-Thin.ttf");
        else if(type==FontType.ROBOTO_MEDIUM)
            typeface= Typeface.createFromAsset(Application.mContext.getAssets(), "fonts/Roboto-Medium.ttf");
        else if(type==FontType.ROBOTO_CONDENSED)
            typeface= Typeface.createFromAsset(Application.mContext.getAssets(), "fonts/Roboto-Condensed.ttf");
        else if(type==FontType.ROBOTO_BOLD)
            typeface= Typeface.createFromAsset(Application.mContext.getAssets(), "fonts/Roboto-Bold.ttf");
        else if(type==FontType.ROBOTO_REGULAR)
            typeface= Typeface.createFromAsset(Application.mContext.getAssets(), "fonts/Roboto-Regular.ttf");

        return typeface;
    }
}
