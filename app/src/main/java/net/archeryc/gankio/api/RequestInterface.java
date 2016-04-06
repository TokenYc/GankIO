package net.archeryc.gankio.api;

import net.archeryc.gankio.POJO.ImagePOJO;
import net.archeryc.gankio.POJO.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by .cc on 2016/3/30.
 * 请求定义的接口
 */
public class RequestInterface {
//    public enum Types {
//        福利("福利"), Android("Android"), iOS("iOS"), 休息视频("休息视频"), 拓展资源("拓展视频"), 前端("前端"), all("all");
//
//        private String type;
//
//        private Types(String type) {
//            this.type = type;
//        }
//
//        public String getType(){
//            return this.type;
//        }
//    }

    public interface ImageService {
        @GET("福利/10/{page}")
        Call<List<ImagePOJO>> listImages(@Path("page") int page);
    }
}
