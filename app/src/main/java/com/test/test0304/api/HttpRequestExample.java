package com.test.test0304.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.test.test0304.model.LoginResponse;
import com.test.test0304.model.UserInfo;
import com.zhuhai.network.http.HttpManager;
import com.zhuhai.network.http.callback.RequestCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * HTTP请求示例类
 * 演示不同类型的HTTP请求调用方式
 */
public class HttpRequestExample {
    private static final String TAG = "HttpRequestExample";
    private Context context;
    private UserApiService userApiService;
    
    public HttpRequestExample(Context context) {
        this.context = context;
        this.userApiService = UserApiService.getInstance();
    }
    
    /**
     * 显示Toast消息
     */
    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    
    /**
     * 日志输出
     */
    private void log(String message) {
        Log.d(TAG, message);
    }

    /**
     * GET请求示例
     */
    public void getRequestExample() {
        log("执行GET请求");
        userApiService.getUserInfo(123, new RequestCallback<UserInfo>() {
            @Override
            public void onStart() {
                log("GET请求开始");
            }
            
            @Override
            public void onSuccess(UserInfo data) {
                log("GET请求成功: " + data);
                showToast("获取用户信息成功");
            }
            
            @Override
            public void onError(int code, String message) {
                log("GET请求失败: " + message);
                showToast("GET失败: " + message);
            }
            
            @Override
            public void onComplete() {
                log("GET请求完成");
            }
        });
    }

    /**
     * POST请求(key-value形式)示例
     */
    public void postFormRequestExample() {
        log("执行POST表单请求");
        userApiService.login("zhangsan", "123456", new RequestCallback<LoginResponse>() {
            @Override
            public void onStart() {
                log("POST表单请求开始");
            }
            
            @Override
            public void onSuccess(LoginResponse data) {
                log("POST表单请求成功: " + data);
                showToast("登录成功");
            }
            
            @Override
            public void onError(int code, String message) {
                log("POST表单请求失败: " + message);
                showToast("POST表单失败: " + message);
            }
            
            @Override
            public void onComplete() {
                log("POST表单请求完成");
            }
        });
    }

    /**
     * POST请求(JSON形式)示例
     */
    public void postJsonRequestExample() {
        log("执行POST JSON请求");
        
        // 创建用户对象
        UserInfo newUser = new UserInfo();
        newUser.setUsername("lisi");
        newUser.setEmail("lisi@example.com");
        newUser.setAge(28);
        newUser.setGender("男");

        userApiService.createUser(newUser, new RequestCallback<UserInfo>() {
            @Override
            public void onStart() {
                log("POST JSON请求开始");
            }
            
            @Override
            public void onSuccess(UserInfo data) {
                log("POST JSON请求成功: " + data);
                showToast("用户创建成功");
            }
            
            @Override
            public void onError(int code, String message) {
                log("POST JSON请求失败: " + message);
                showToast("POST JSON失败: " + message);
            }
            
            @Override
            public void onComplete() {
                log("POST JSON请求完成");
            }
        });
    }

    /**
     * PUT请求示例
     */
    public void putRequestExample() {
        log("执行PUT请求");
        
        // 创建要更新的用户信息
        UserInfo updateInfo = new UserInfo();
        updateInfo.setEmail("lisi_new@example.com");
        updateInfo.setPhone("13800138000");

        userApiService.updateUser(123, updateInfo, new RequestCallback<UserInfo>() {
            @Override
            public void onStart() {
                log("PUT请求开始");
            }
            
            @Override
            public void onSuccess(UserInfo data) {
                log("PUT请求成功: " + data);
                showToast("用户信息更新成功");
            }
            
            @Override
            public void onError(int code, String message) {
                log("PUT请求失败: " + message);
                showToast("PUT失败: " + message);
            }
            
            @Override
            public void onComplete() {
                log("PUT请求完成");
            }
        });
    }

    /**
     * DELETE请求(单个数据)示例
     */
    public void deleteRequestExample() {
        log("执行DELETE请求");
        userApiService.deleteUser(123, new RequestCallback<Void>() {
            @Override
            public void onStart() {
                log("DELETE请求开始");
            }
            
            @Override
            public void onSuccess(Void data) {
                log("DELETE请求成功");
                showToast("用户删除成功");
            }
            
            @Override
            public void onError(int code, String message) {
                log("DELETE请求失败: " + message);
                showToast("DELETE失败: " + message);
            }
            
            @Override
            public void onComplete() {
                log("DELETE请求完成");
            }
        });
    }

    /**
     * DELETE请求(多个数据)示例
     */
    public void batchDeleteRequestExample() {
        log("执行批量DELETE请求");

//        HttpManager.getInstance().addGlobalHeader("token", "a373805dc17744bfb9eb0d77bfcfe045");
        
        // 创建要删除的用户ID列表
        List<String> userIdList = new ArrayList<>();
        userIdList.add("6745709cf412fdc1659192ad");

        userApiService.batchDeleteUsers(userIdList, new RequestCallback<String>() {
            @Override
            public void onStart() {
                log("批量DELETE请求开始");
            }
            
            @Override
            public void onSuccess(String data) {
                log("批量DELETE请求成功==>"+data);
                if ("操作成功".equals(data)){
                    showToast("批量删除用户真正成功");
                }else {
                    showToast("批量删除用户并没有真正成功");
                }
            }
            
            @Override
            public void onError(int code, String message) {
                log("批量DELETE请求失败=============: " + message);
                showToast("批量DELETE失败: " + message);
            }
            
            @Override
            public void onComplete() {
                log("批量DELETE请求完成");
            }
        });
    }
} 