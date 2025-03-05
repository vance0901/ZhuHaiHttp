package com.test.test0304.api.wanandroid;

import com.test.test0304.model.wanandroid.UserInfoResponse;
import com.zhuhai.network.http.model.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * WanAndroid网站API接口
 */
public interface WanAndroidApiService {
    /**
     * 获取用户信息
     * 
     * @return 用户信息响应
     */
    @GET("user/lg/userinfo/json")
    Call<BaseResponse<UserInfoResponse>> getUserInfo();
    
    /**
     * 用户登录
     * 
     * @param username 用户名
     * @param password 密码
     * @return 登录响应
     */
    @FormUrlEncoded
    @POST("user/login")
    Call<BaseResponse<UserInfoResponse>> login(
            @Field("username") String username, 
            @Field("password") String password
    );
} 