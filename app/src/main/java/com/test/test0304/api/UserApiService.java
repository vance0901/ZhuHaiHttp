package com.test.test0304.api;

import com.test.test0304.model.LoginResponse;
import com.test.test0304.model.UserInfo;
import com.zhuhai.network.http.callback.RequestCallback;
import com.zhuhai.network.http.service.BaseApiService;

import java.util.List;

/**
 * 用户API服务类，继承自BaseApiService
 * 使用更优化的架构，避免重复代码
 */
public class UserApiService extends BaseApiService<UserApiServiceInterface> {
    private static volatile UserApiService instance;
    
    private UserApiService() {
        super();
    }
    
    /**
     * 获取UserApiService单例实例
     */
    public static UserApiService getInstance() {
        if (instance == null) {
            synchronized (UserApiService.class) {
                if (instance == null) {
                    instance = new UserApiService();
                }
            }
        }
        return instance;
    }
    
    @Override
    protected Class<UserApiServiceInterface> getApiServiceClass() {
        return UserApiServiceInterface.class;
    }
    
    /**
     * GET请求 - 获取用户信息
     */
    public void getUserInfo(long userId, RequestCallback<UserInfo> callback) {
        executeRequest(apiService.getUserInfo(userId), callback);
    }
    
    /**
     * GET请求带参数 - 获取用户列表
     */
    public void getUserList(int page, int size, RequestCallback<List<UserInfo>> callback) {
        executeRequest(apiService.getUserList(page, size), callback);
    }
    
    /**
     * POST请求(表单) - 登录
     */
    public void login(String username, String password, RequestCallback<LoginResponse> callback) {
        executeRequest(apiService.login(username, password), callback);
    }
    
    /**
     * POST请求(JSON) - 创建用户
     */
    public void createUser(UserInfo userInfo, RequestCallback<UserInfo> callback) {
        executeRequest(apiService.createUser(userInfo), callback);
    }
    
    /**
     * PUT请求 - 更新用户信息
     */
    public void updateUser(long userId, UserInfo userInfo, RequestCallback<UserInfo> callback) {
        executeRequest(apiService.updateUser(userId, userInfo), callback);
    }
    
    /**
     * DELETE请求 - 删除用户
     */
    public void deleteUser(long userId, RequestCallback<Void> callback) {
        executeRequest(apiService.deleteUser(userId), callback);
    }
    
    /**
     * DELETE请求(批量) - 批量删除用户
     */
    public void batchDeleteUsers(List<String> userIds, RequestCallback<String> callback) {
        executeRequest(apiService.batchDeleteUsers(userIds), callback);
    }
} 