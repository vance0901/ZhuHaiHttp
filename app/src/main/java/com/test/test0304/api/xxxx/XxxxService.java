package com.test.test0304.api.xxxx;

import com.test.test0304.model.xx.XxLoginRequest;
import com.test.test0304.model.xx.XxRequest;
import com.test.test0304.model.xx.DeleteResponse;
import com.test.test0304.model.xx.XxLoginResponse;
import com.test.test0304.model.xx.UserUpdateRequest;
import com.test.test0304.model.xx.UserUpdateResponse;
import com.vance0901.zhuhai.network.http.callback.RequestCallback;
import com.vance0901.zhuhai.network.http.model.BaseResponse;
import com.vance0901.zhuhai.network.http.service.BaseApiService;

import java.util.List;

/**
 * x业xxxxxAPI服务类
 */
public class XxxxService extends BaseApiService<XxxxApiService> {
    private static volatile XxxxService instance;
    
    private XxxxService() {
        super();
    }
    
    /**
     * 获取服务单例实例
     * 
     * @return xxxxService实例
     */
    public static XxxxService getInstance() {
        if (instance == null) {
            synchronized (XxxxService.class) {
                if (instance == null) {
                    instance = new XxxxService();
                }
            }
        }
        return instance;
    }
    
    @Override
    protected Class<XxxxApiService> getApiServiceClass() {
        return XxxxApiService.class;
    }
    
    /**
     * 用户登录 - JSON提交方式
     * 
     * @param phone 手机号
     * @param verifyCode 验证码
     * @param callback 请求回调
     */
    public void login(String phone, String verifyCode, RequestCallback<XxLoginResponse> callback) {
        XxLoginRequest request = new XxLoginRequest(phone, verifyCode);
        executeRequest(apiService.login(request), callback);
    }
    
    /**
     * 更新用户信息 - PUT请求(JSON方式)
     * 
     * @param updateRequest 用户信息更新请求
     * @param callback 请求回调
     */
    public void updateUserInfo(UserUpdateRequest updateRequest, RequestCallback<UserUpdateResponse> callback) {
        executeRequest(apiService.updateUserInfo(updateRequest), callback);
    }
    
    /**
     * 执行删除数据请求 - 单个ID删除
     *
     * @param id 要删除的ID
     * @param callback 回调
     */
    public void deleteData(String id, RequestCallback<DeleteResponse> callback) {
        XxRequest request = new XxRequest();
        request.addId(id);
        executeDeleteRequest(apiService.deleteData(request), callback);
    }
    
    /**
     * 执行批量删除数据请求
     *
     * @param ids 要删除的ID列表
     * @param callback 回调
     */
    public void deleteData(List<String> ids, RequestCallback<DeleteResponse> callback) {
        XxRequest request = new XxRequest(ids);
        executeDeleteRequest(apiService.deleteData(request), callback);
    }
    
    /**
     * 执行删除请求并将String类型的响应转换为DeleteResponse
     *
     * @param call 原始API调用
     * @param callback 回调
     */
    private void executeDeleteRequest(retrofit2.Call<BaseResponse<String>> call,
                                      final RequestCallback<DeleteResponse> callback) {
        if (callback != null) {
            callback.onStart();
        }

        call.enqueue(new retrofit2.Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(retrofit2.Call<BaseResponse<String>> call,
                                 retrofit2.Response<BaseResponse<String>> response) {
                if (callback != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse<String> baseResponse = response.body();
                        if (baseResponse.isSuccess()) {
                            // 将String转换为DeleteResponse
                            DeleteResponse deleteResponse = new DeleteResponse();
                            deleteResponse.setCode(baseResponse.getErrorCode());
                            deleteResponse.setMsg(baseResponse.getErrorMsg());
                            deleteResponse.setData(baseResponse.getData());
                            callback.onSuccess(deleteResponse);
                        } else {
                            callback.onError(baseResponse.getErrorCode(), baseResponse.getErrorMsg());
                        }
                    } else {
                        callback.onError(-1, response.message());
                    }
                    callback.onComplete();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<BaseResponse<String>> call, Throwable t) {
                if (callback != null) {
                    callback.onError(-1, t.getMessage());
                    callback.onComplete();
                }
            }
        });
    }
} 