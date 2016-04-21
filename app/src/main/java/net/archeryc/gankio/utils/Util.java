package net.archeryc.gankio.utils;

import android.content.Context;

/**
 * Created by 24706 on 2016/4/21.
 */
public class Util {
    /**
     * @param context
     * @return int
     * @description: 获取屏幕宽
     */
    public static int screenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     * @param context
     * @return
     */
    public static int screenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
