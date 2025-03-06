package com.zhuhai.network.http.interceptor;

import android.text.TextUtils;
import android.util.Log;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 请求头拦截器 Request header interceptor
 * 支持全局请求头和单个请求的自定义请求头
 */
public class HeaderInterceptor implements Interceptor {

    // 全局token
    private String globalToken = "";
    
    // 全局请求头
    private  Map<String, String> globalHeaders = new ConcurrentHashMap<>();
    
    // 用于标识请求特定token的Header名称
    private static final String REQUEST_TOKEN_HEADER = "X-Request-Token";
    
    // 用于标识是否移除该Header的前缀
    private static final String REMOVE_HEADER_PREFIX = "X-Remove-Header:";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder builder = originalRequest.newBuilder();

        for (Map.Entry<String, String> entry : globalHeaders.entrySet()) {
            Log.e("Key:==>"+entry.getKey(),"Value====>"+entry.getValue());
        }
        
        // 处理全局请求头
        for (Map.Entry<String, String> entry : globalHeaders.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }



//        // 处理全局token
//        String token = getGlobalToken();
//        if (token != null && !token.isEmpty()) {
//            builder.addHeader("token", token);
//        }
//
//        // 处理单个请求的token
//        String requestToken = originalRequest.header(REQUEST_TOKEN_HEADER);
//        if (requestToken != null && !requestToken.isEmpty()) {
//            // 移除临时token header，避免发送到服务器
//            builder.removeHeader(REQUEST_TOKEN_HEADER);
//            // 使用请求特定的token替换全局token
//            builder.header("token", requestToken);
//        }
//
//        // 处理需要移除的header
//        for (String name : originalRequest.headers().names()) {
//            if (name.startsWith(REMOVE_HEADER_PREFIX)) {
//                String headerToRemove = name.substring(REMOVE_HEADER_PREFIX.length());
//                builder.removeHeader(headerToRemove);
//                builder.removeHeader(name); // 同时移除这个标记header
//            }
//        }
        
        return chain.proceed(builder.build());
    }

    /**
     * 获取全局Token
     * @return 全局Token
     */
    private String getGlobalToken() {
        return globalToken;
    }

    /**
     * 设置全局Token
     * @param token 要设置的Token
     */
    public void setGlobalToken(String token) {
        this.globalToken = token != null ? token : "";
    }
    
    /**
     * 添加全局请求头
     * @param key 请求头名称
     * @param value 请求头值
     */
    public void addGlobalHeader(String key, String value) {
        if (key != null && value != null) {
            globalHeaders.put(key, value);
        }
    }
    
    /**
     * 移除全局请求头
     * @param key 请求头名称
     */
    public void removeGlobalHeader(String key) {
        if (!TextUtils.isEmpty(key)) {
            globalHeaders.remove(key);
            Log.d("HeaderInterceptor", "已移除全局请求头: " + key);
        }
    }
    
    /**
     * 清除全局请求头
     */
    public void clearGlobalHeaders() {
        globalHeaders.clear();
    }
    
    /**
     * 获取全局请求头的副本
     * @return 全局请求头Map
     */
    public Map<String, String> getGlobalHeaders() {
        return new HashMap<>(globalHeaders);
    }
}