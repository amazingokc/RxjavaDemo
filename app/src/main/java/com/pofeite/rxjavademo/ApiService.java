package com.pofeite.rxjavademo;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by xgj on 2016/7/14.
 */
public interface ApiService {

    @GET("service/getIpInfo.php")
    Observable<GetIpInfoResponse> getIpInfo(@Query("ip") String ip);

}
