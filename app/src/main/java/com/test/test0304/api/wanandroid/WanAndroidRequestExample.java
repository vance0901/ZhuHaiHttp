package com.test.test0304.api.wanandroid;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.test.test0304.model.wanandroid.UserInfoResponse;
import com.zhuhai.network.http.callback.RequestCallback;

/**
 * WanAndroid API请求示例类
 */
public class WanAndroidRequestExample {
    private static final String TAG = "WanAndroidRequest";
    private final Context context;
    private final WanAndroidService wanAndroidService;
    
    public WanAndroidRequestExample(Context context) {
        this.context = context;
        this.wanAndroidService = WanAndroidService.getInstance();
    }
    
    /**
     * 用户登录示例
     * 使用POST表单提交方式
     * 
     * @param username 用户名
     * @param password 密码
     */
    public void loginExample(String username, String password) {
        Log.d(TAG, "开始执行登录请求...");
        Toast.makeText(context, "正在登录...", Toast.LENGTH_SHORT).show();
        
        wanAndroidService.login(username, password, new RequestCallback<UserInfoResponse>() {
            @Override
            public void onStart() {
                Log.d(TAG, "登录请求开始");
            }
            
            @Override
            public void onSuccess(UserInfoResponse data) {
                Log.d(TAG, "登录成功: " + data.toString());
                Toast.makeText(context, "登录成功，欢迎 " + 
                        (data.getUserInfo() != null ? data.getUserInfo().getUsername() : "用户"), 
                        Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onError(int code, String message) {
                Log.e(TAG, "登录失败: code=" + code + ", message=" + message);
                Toast.makeText(context, "登录失败: " + message, Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onComplete() {
                Log.d(TAG, "登录请求完成");
            }
        });
    }
    
    /**
     * 获取用户信息示例
     */
    public void getUserInfoExample() {
        wanAndroidService.getUserInfo(new RequestCallback<UserInfoResponse>() {
            @Override
            public void onStart() {
                Log.d(TAG, "开始获取用户信息");
            }
            
            @Override
            public void onSuccess(UserInfoResponse data) {
                Log.d(TAG, "获取用户信息成功: " + data.toString());
                Toast.makeText(context, "获取用户信息成功", Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onError(int code, String message) {
                Log.e(TAG, "获取用户信息失败: " + message);
                Toast.makeText(context, "获取用户信息失败: " + message, Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onComplete() {
                Log.d(TAG, "获取用户信息请求完成");
            }
        });
    }
}