package com.vance0901.zhuhai.network.http;

import com.vance0901.zhuhai.network.http.config.HttpConfig;
import com.vance0901.zhuhai.network.http.interceptor.HeaderInterceptor;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * HTTP请求管理类 HTTP request management class
 */
public class HttpManager {
    private static volatile HttpManager instance;
    private final HttpConfig config;
    private final Retrofit retrofit;
    private final HeaderInterceptor headerInterceptor;

    private HttpManager(HttpConfig config) {
        this.config = config;
        this.headerInterceptor = new HeaderInterceptor();
        this.retrofit = createRetrofit();
    }

    public static void init(HttpConfig config) {
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new HttpManager(config);
                }
            }
        }
    }

    public static HttpManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Http Manager is initialized first");
        }
        return instance;
    }

    private Retrofit createRetrofit() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(config.getConnectTimeout(), TimeUnit.MILLISECONDS)
                .readTimeout(config.getReadTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(config.getWriteTimeout(), TimeUnit.MILLISECONDS)
                .addInterceptor(headerInterceptor);

        if (config.isDebug()) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(config.getLogLevel());
            clientBuilder.addInterceptor(loggingInterceptor);
        }

        return new Retrofit.Builder()
                .baseUrl(config.getBaseUrl())
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T createApi(Class<T> apiClass) {
        return retrofit.create(apiClass);
    }
    
    /**
     * 设置全局Token
     * @param token 要设置的Token
     */
    public void setGlobalToken(String token) {
        headerInterceptor.setGlobalToken(token);
    }
    
    /**
     * 添加全局请求头
     * @param key 请求头名称
     * @param value 请求头值
     */
    public void addGlobalHeader(String key, String value) {
        headerInterceptor.addGlobalHeader(key, value);
    }
    
    /**
     * 添加多个全局请求头
     * @param headers 请求头键值对Map
     */
    public void addGlobalHeaders(Map<String, String> headers) {
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                headerInterceptor.addGlobalHeader(entry.getKey(), entry.getValue());
            }
        }
    }
    
    /**
     * 移除全局请求头
     * @param key 请求头名称
     */
    public void removeGlobalHeader(String key) {
        headerInterceptor.removeGlobalHeader(key);
    }
    

    /**
     * 获取全局请求头的副本
     * @return 全局请求头Map
     */
    public Map<String, String> getGlobalHeaders() {
        return headerInterceptor.getGlobalHeaders();
    }
    
    /**
     * 为单个请求设置Token
     * @param builder 请求构建器
     * @param token Token值
     * @return 更新后的请求构建器
     */
    public Request.Builder setRequestToken(Request.Builder builder, String token) {
        if (builder != null && token != null) {
            builder.header("X-Request-Token", token);
        }
        return builder;
    }
    
    /**
     * 为单个请求移除指定请求头
     * @param builder 请求构建器
     * @param headerName 要移除的请求头名称
     * @return 更新后的请求构建器
     */
    public Request.Builder removeRequestHeader(Request.Builder builder, String headerName) {
        if (builder != null && headerName != null) {
            builder.header("X-Remove-Header:" + headerName, "true");
        }
        return builder;
    }
} 