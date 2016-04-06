package net.archeryc.gankio;

import android.app.Application;

import com.jiongbull.jlog.JLog;

/**
 * Created by .cc on 2016/4/6.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JLog.init(this)
                .setDebug(BuildConfig.DEBUG);
    }
}
