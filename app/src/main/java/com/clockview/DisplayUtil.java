package com.clockview;

import android.content.Context;

/**
 * Created by Administrator on 2016/11/1.
 */
public class DisplayUtil {
    public static int px2dip(Context context,float pxValue) {
        return (int) (pxValue / context.getResources().getDisplayMetrics().density + 0.5f);
    }


    public static int dip2px(Context context,float dipValue) {
        return (int) (dipValue * context.getResources().getDisplayMetrics().density + 0.5f);
    }


    public static int px2sp(Context context,float pxValue) {
        return (int) (pxValue / context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }


    public static int sp2px(Context context,float spValue) {
        return (int) (spValue * context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }
}
