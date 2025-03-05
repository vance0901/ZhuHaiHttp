package com.test.test0304.api.xxxxx;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.test.test0304.model.xx.DeleteResponse;
import com.test.test0304.model.xx.UserUpdateRequest;
import com.test.test0304.model.xx.UserUpdateResponse;
import com.test.test0304.model.xx.XxLoginResponse;
import com.zhuhai.network.http.HttpManager;
import com.zhuhai.network.http.callback.RequestCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * xxxx业xxxAPI请求示例
 */
public class XxxxxRequestExample {
    private static final String TAG = "xxxxxRequest";
    private final Context context;
    private final XxxxxService xxxxxService;
    
    public XxxxxRequestExample(Context context) {
        this.context = context;
        this.xxxxxService = XxxxxService.getInstance();
    }
    
    /**
     * 设置认证头示例 - 向HTTP请求添加Token
     *
     * @param token 认证Token
     */
    public void setAuthTokenExample(String token) {
        Log.d(TAG, "设置认证Token: " + token);
        
        // 方式一：使用应用程序类提供的方法设置Token
//        TestApplication.setAuthToken(token);
        
        // 方式二：直接使用HttpManager设置Token
        // HttpManager.getInstance().addToken(token);
        
        Toast.makeText(context, "认证Token已设置", Toast.LENGTH_SHORT).show();
    }
    
    /**
     * 设置自定义请求头示例
     *
     * @param headerKey 请求头名称
     * @param headerValue 请求头值
     */
    public void setCustomHeaderExample(String headerKey, String headerValue) {
        Log.d(TAG, "设置自定义请求头: " + headerKey + " = " + headerValue);
        
        // 方式一：使用应用程序类提供的方法设置自定义头
//        TestApplication.setCustomHeader(headerKey, headerValue);
        
        // 方式二：直接使用HttpManager设置自定义头
//         HttpManager.getInstance().addHeader(headerKey, headerValue);
        
        Toast.makeText(context, "自定义请求头已设置", Toast.LENGTH_SHORT).show();
    }
    
    /**
     * 清除请求头示例
     */
    public void clearHeadersExample() {
        Log.d(TAG, "清除请求头");
        
        // 方式一：使用应用程序类提供的方法清除头
//        TestApplication.clearAllHeaders();
        
        // 方式二：直接使用HttpManager清除头
        // HttpManager.getInstance().clearHeaders();
        
//        Toast.makeText(context, "所有请求头已清除", Toast.LENGTH_SHORT).show();
    }
    
    /**
     * 登录示例 - JSON提交方式
     * 
     * @param phone 手机号
     * @param verifyCode 验证码
     */
    public void loginJsonExample(String phone, String verifyCode) {
        xxxxxService.login(phone, verifyCode, new RequestCallback<XxLoginResponse>() {
            @Override
            public void onStart() {
                Log.d(TAG, "开始登录请求");
                Toast.makeText(context, "开始登录请求", Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onSuccess(XxLoginResponse data) {
                String message = "登录成功: " + data;
                Log.d(TAG, message);
                
                // 登录成功后，设置认证Token
//                if (data != null && data.getToken() != null) {
//                    setAuthTokenExample(data.getToken());
//                }
//
//                Toast.makeText(context, "登录成功: " +
//                        (data != null ? data.getMessage() : ""), Toast.LENGTH_LONG).show();
            }
            
            @Override
            public void onError(int code, String message) {
                Log.e(TAG, "登录失败: " + code + ", " + message);
                Toast.makeText(context, "登录失败: " + message, Toast.LENGTH_LONG).show();
            }
            
            @Override
            public void onComplete() {
                Log.d(TAG, "登录请求完成");
            }
        });
    }
    
    /**
     * 更新用户信息示例 - PUT请求(JSON方式)
     * 
     * @param userId 用户ID
     * @param userName 用户名
     * @param phone 手机号
     * @param sex 性别(0-未知, 1-男, 2-女)
     * @param birth 出生日期
     * @param address 地址
     * @param region 地区
     * @param verifyCode 验证码
     */
    public void updateUserInfoExample(int userId, String userName, String phone, int sex, 
                                 String birth, String address, String region, String verifyCode) {
        // 使用Builder模式构建请求对象
        UserUpdateRequest request = new UserUpdateRequest.Builder()
                .userId(userId)
                .userName(userName)
                .phone(phone)
                .sex(sex)
                .birth(birth)
                .address(address)
                .region(region)
                .verifyCode(verifyCode)
                .build();
                
        xxxxxService.updateUserInfo(request, new RequestCallback<UserUpdateResponse>() {
            @Override
            public void onStart() {
                Log.d(TAG, "开始更新用户信息请求");
                Toast.makeText(context, "开始更新用户信息", Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onSuccess(UserUpdateResponse data) {
                String message = "更新用户信息成功: " + data;
                Log.d(TAG, message);
                Toast.makeText(context, "更新成功: " + 
                        (data != null ? data.getMessage() : ""), Toast.LENGTH_LONG).show();
            }
            
            @Override
            public void onError(int code, String message) {
                Log.e(TAG, "更新用户信息失败: " + code + ", " + message);
                Toast.makeText(context, "更新失败: " + message, Toast.LENGTH_LONG).show();
            }
            
            @Override
            public void onComplete() {
                Log.d(TAG, "更新用户信息请求完成");
            }
        });
    }
    
    /**
     * 删除数据示例 - DELETE请求，单个ID删除
     *
     * @param id 要删除的ID
     */
//    public void deleteDataExample(String id) {
//        // 在发送删除请求前添加token header
//        HttpManager.getInstance().addGlobalHeader("token", "12345678abcdef");
//        Log.d(TAG, "添加删除请求token header: token=12345678abcdef");
//
//        xxxxxService.deleteData(id, new RequestCallback<DeleteResponse>() {
//            @Override
//            public void onStart() {
//                Log.d(TAG, "开始删除数据请求");
//                Toast.makeText(context, "开始删除数据", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onSuccess(DeleteResponse data) {
//                String message = "删除数据成功: " + data;
//                Log.d(TAG, message);
////                Toast.makeText(context, "删除成功: " +
////                        (data != null ? data.getMessage() + ", 删除数量: " + data.getDeletedCount() : ""),
////                        Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onError(int code, String message) {
//                Log.e(TAG, "删除数据失败: " + code + ", " + message);
//                Toast.makeText(context, "删除失败: " + message, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "删除数据请求完成");
//            }
//        });
//    }
    
    /**
     * 批量删除数据示例 - DELETE请求(JSON方式)，多个ID删除
     *
     * @param ids 要删除的ID列表
     */
//    public void batchDeleteDataExample(List<String> ids) {
//        // 在发送批量删除请求前添加token header
//        HttpManager.getInstance().addGlobalHeader("token", "12345678abcdef");
//        Log.d(TAG, "添加批量删除请求token header: token=12345678abcdef");
//
//        xxxxxService.deleteData(ids, new RequestCallback<DeleteResponse>() {
//            @Override
//            public void onStart() {
//                Log.d(TAG, "开始批量删除数据请求");
//                Toast.makeText(context, "开始批量删除数据", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onSuccess(DeleteResponse data) {
//                String message = "批量删除数据成功: " + data;
//                Log.d(TAG, message);
////                Toast.makeText(context, "批量删除成功: " +
////                        (data != null ? data.getMessage() + ", 删除数量: " + data.getDeletedCount() : ""),
////                        Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onError(int code, String message) {
//                Log.e(TAG, "批量删除数据失败: " + code + ", " + message);
//                // 添加详细错误信息，包括完整的异常堆栈
//                if (message != null && message.contains("Expected BEGIN_OBJECT but was STRING")) {
//                    Log.e(TAG, "JSON解析错误: 服务器返回的data字段是字符串，但期望是对象。这是类型不匹配导致的，已修复DeleteResponse类。");
//                    // 尝试显示成功信息，因为从错误信息中可以看出实际请求成功了
//                    Toast.makeText(context, "删除操作实际已成功，但存在数据解析问题，请检查日志", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                Toast.makeText(context, "批量删除失败: " + message, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "批量删除数据请求完成");
//            }
//        });
//    }
    
    /**
     * 快速批量删除数据示例 - 使用预设ID列表
     * 
     * @param id 要删除的ID（如果提供则只删除此ID，否则使用默认ID示例）
     */
    public void quickDeleteExample(String id) {
//        if (id != null && !id.isEmpty()) {
//            // 单个ID删除
//            deleteDataExample(id);
//        } else {
//            // 使用预设ID示例进行批量删除
//            List<String> idList = new ArrayList<>();
//            idList.add("6745709cf412fdc1659192ad");
//            // 可以添加更多ID
//            batchDeleteDataExample(idList);
//        }
    }
} 