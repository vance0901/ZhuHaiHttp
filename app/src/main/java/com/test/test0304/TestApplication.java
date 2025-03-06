package com.test.test0304;

import android.app.Application;
import android.util.Log;

import com.zhuhai.network.http.HttpManager;
import com.zhuhai.network.http.config.HttpConfig;

import okhttp3.logging.HttpLoggingInterceptor;

import java.util.Map;

/**
 * 应用程序入口类
 * 用于初始化全局组件
 */
public class TestApplication extends Application {
    private static final String TAG = "TestApplication";
    
    // 基础URL
    private static final String BASE_URL = "https://yourapi.com";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "应用启动，开始初始化...");
        
        // 初始化HTTP管理器
        initHttpManager();
        
        Log.d(TAG, "应用初始化完成");
    }
    
    /**
     * 初始化HTTP管理器
     */
    private void initHttpManager() {
        // 创建HTTP配置
        HttpConfig config = new HttpConfig.Builder()
                .baseUrl(BASE_URL)          // 设置基础URL
                .connectTimeout(30000)      // 连接超时时间30秒
                .readTimeout(30000)         // 读取超时时间30秒
                .writeTimeout(30000)        // 写入超时时间30秒
                .debug(true)                // 开启调试模式
                .logLevel(HttpLoggingInterceptor.Level.BODY) // 设置日志级别为BODY
                .build();
        
        // 初始化HTTP管理器
        HttpManager.init(config);
        
        Log.d(TAG, "HTTP管理器初始化完成: " + BASE_URL);
    }
    
    /**
     * 移除指定的全局请求头
     * 
     * @param headerKey 请求头名称
     */
    public static void removeCustomHeader(String headerKey) {
        if (headerKey == null || headerKey.isEmpty()) {
            Log.w(TAG, "尝试移除空的请求头名称");
            return;
        }
        
        // 记录当前的全局请求头状态
        Map<String, String> beforeHeaders = HttpManager.getInstance().getGlobalHeaders();
        Log.d(TAG, "移除前的请求头: " + beforeHeaders);
        
        // 执行移除操作
        Log.d(TAG, "正在移除全局请求头: " + headerKey);
        HttpManager.getInstance().removeGlobalHeader(headerKey);
        
        // 再次获取全局请求头状态，检查是否成功移除
        Map<String, String> afterHeaders = HttpManager.getInstance().getGlobalHeaders();
        Log.d(TAG, "移除后的请求头: " + afterHeaders);
        
        // 检查是否成功移除
        if (afterHeaders.containsKey(headerKey)) {
            Log.e(TAG, "警告: 请求头 '" + headerKey + "' 可能未被完全移除");
        } else {
            Log.d(TAG, "请求头 '" + headerKey + "' 已成功移除");
        }
    }
} 