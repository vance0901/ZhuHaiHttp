package com.test.test0304.api;

import com.test.test0304.model.LoginResponse;
import com.test.test0304.model.UserInfo;
import com.vance0901.zhuhai.network.http.model.BaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * API接口定义
 */
public interface UserApiServiceInterface {
    // 获取用户信息
    @GET("users/{id}")
    Call<BaseResponse<UserInfo>> getUserInfo(@Path("id") long id);
    
    // 获取用户列表
    @GET("users")
    Call<BaseResponse<List<UserInfo>>> getUserList(@Query("page") int page, @Query("size") int size);
    
    // 用户登录(表单方式)
    @FormUrlEncoded
    @POST("users/login")
    Call<BaseResponse<LoginResponse>> login(
        @Field("username") String username,
        @Field("password") String password
    );
    
    // 创建用户(JSON方式)
    @POST("users/create")
    Call<BaseResponse<UserInfo>> createUser(@Body UserInfo userInfo);
    
    // 更新用户信息
    @PUT("users/{id}")
    Call<BaseResponse<UserInfo>> updateUser(
        @Path("id") long id, 
        @Body UserInfo userInfo
    );
    
    // 删除单个用户
    @DELETE("users/{id}")
    Call<BaseResponse<Void>> deleteUser(@Path("id") long id);
    
    // 批量删除用户
    @HTTP(method = "DELETE", path = "delete", hasBody = true)
    Call<BaseResponse<String>> batchDeleteUsers(@Body List<String> userIds);
} 