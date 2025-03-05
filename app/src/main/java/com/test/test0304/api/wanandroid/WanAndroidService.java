package com.test.test0304.api.wanandroid;

import com.test.test0304.model.wanandroid.UserInfoResponse;
import com.zhuhai.network.http.callback.RequestCallback;
import com.zhuhai.network.http.service.BaseApiService;

/**
 * WanAndroid网站服务类
 */
public class WanAndroidService extends BaseApiService<WanAndroidApiService> {
    private static volatile WanAndroidService instance;
    
    private WanAndroidService() {
        super();
    }
    
    /**
     * 获取WanAndroidService单例实例
     * 
     * @return WanAndroidService实例
     */
    public static WanAndroidService getInstance() {
        if (instance == null) {
            synchronized (WanAndroidService.class) {
                if (instance == null) {
                    instance = new WanAndroidService();
                }
            }
        }
        return instance;
    }
    
    @Override
    protected Class<WanAndroidApiService> getApiServiceClass() {
        return WanAndroidApiService.class;
    }
    
    /**
     * 获取用户信息
     * 
     * @param callback 请求回调
     */
    public void getUserInfo(RequestCallback<UserInfoResponse> callback) {
        executeRequest(apiService.getUserInfo(), callback);
    }
    
    /**
     * 用户登录
     * 
     * @param username 用户名
     * @param password 密码
     * @param callback 请求回调
     */
    public void login(String username, String password, RequestCallback<UserInfoResponse> callback) {
        executeRequest(apiService.login(username, password), callback);
    }
} 