package net.archeryc.gankio.api;



import com.jiongbull.jlog.JLog;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by .cc on 2016/3/30.
 */
public class LogInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        JLog.d("yangchen","拦截成功");
        Request request = chain.request().newBuilder().addHeader("key", "value").build();
        long t1 = System.nanoTime();
        JLog.d("yangchen",String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        JLog.d("yangchen",String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        String str=response.body().toString();
        JLog.json(str);
        return response;
    }
}
