package com.test.test0304.api.xxxxx;

import com.test.test0304.model.xx.UserUpdateRequest;
import com.test.test0304.model.xx.UserUpdateResponse;
import com.test.test0304.model.xx.XxLoginRequest;
import com.test.test0304.model.xx.XxLoginResponse;
import com.vance0901.zhuhai.network.http.model.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * xxxx业xxxAPI接口
 */
public interface XxxxxApiService {
    /**
     * 用户登录 - JSON提交方式
     * 
     * @param loginRequest 登录请求参数
     * @return 登录响应
     */
    @POST("bu-api/v1/analysisUser/login")
    Call<BaseResponse<XxLoginResponse>> login(@Body XxLoginRequest loginRequest);
    
    /**
     * 更新用户信息 - PUT请求(JSON方式)
     * 
     * @param updateRequest 用户信息更新请求
     * @return 更新响应
     */
    @PUT("bu-api/v1/update")
    Call<BaseResponse<UserUpdateResponse>> updateUserInfo(@Body UserUpdateRequest updateRequest);
    
    /**
     * 删除数据 - DELETE请求(JSON提交方式)
     * 使用@HTTP注解以支持带请求体的DELETE请求
     *
     * @param deleteRequest 删除请求（包含要删除的ID列表）
     * @return 删除响应
     */
//    @HTTP(method = "DELETE", path = "bu-api/v1/analysis/delete", hasBody = true)
//    Call<BaseResponse<DeleteResponse>> deleteData(@Body DeleteRequest deleteRequest);
} 