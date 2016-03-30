package net.archeryc.gankio.api;

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

    public interface GithubService {
        @GET("users/{user}/repos") //表示路径path
        Call<List<Repo>> listRepos(@Path("user") String user);//返回的数据转换成什么对象。
    }


}
