package com.zhuhai.network.http.service;

import com.zhuhai.network.http.HttpManager;
import com.zhuhai.network.http.callback.RequestCallback;
import com.zhuhai.network.http.model.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 基础API服务类
 * @param <T> API接口类型
 *
 *           相关介绍：
 * 1.单例模式：
 * HttpManager：管理网络请求的全局单例
 * UserApiService：管理用户相关API的单例
 * 2. 建造者模式：
 * HttpConfig.Builder：用于构建网络配置
 * 工厂模式：
 * HttpManager.createApi()：创建API服务实例
 * 观察者模式：
 * RequestCallback：网络请求回调接口
 * 模板方法模式：
 * BaseApiService：定义了通用的请求处理流程
 * 6. 策略模式：
 * 通过不同的 API 接口实现不同的请求策略
 * 7. 代理模式：
 * HeaderInterceptor：代理所有请求，添加通用请求头
 *
 *           特点：
 * 1.解耦：
 * 网络请求相关代码完全独立为一个模块
 * 业务逻辑与网络请求实现分离
 * 2. 可维护性：
 * 统一的错误处理
 * 统一的请求配置
 * 统一的请求拦截器
 * 3.可扩展性：
 * 易于添加新的API接口
 * 易于添加新的拦截器
 * 易于修改网络配置
 * 4.易用性：
 * 简化的API调用方式
 * 统一的回调接口
 * 清晰的错误提示
 * 5.安全性：
 * 统一的请求头管理
 * 统一的异常处理
 * 线程安全的单例实现
 *
 *
 *           Basic API service class @param <T> API interface type related introduction:
 *           1. Singleton mode: HttpManager: global singleton for managing network requests UserApiService:
 *           singleton for managing user-related apis 2. Builder mode: HttpConfig.Builder: Used to
 *           build network configuration factory mode: HttpManager.createApi() : Create API service
 *           instances Observer mode: RequestCallback: Network request callback interface template
 *           method mode: BaseApiService: Defines a common request processing flow 6. Policy pattern:
 *           Implement different request policies through different API interfaces. Proxy mode:
 *           HeaderInterceptor: proxy all requests, add general request header features: 1. Decoupling:
 *           Network request related code is completely independent into a module business logic and
 *           network request implementation separation 2. Maintainability: Uniform error handling
 *           uniform request configuration uniform request blocker 3. Extensibility: Easy to add
 *           new API interfaces easy to add new interceptors Easy to modify network configuration
 *           4. Ease of use: Simplified API call mode Unified callback interface clear error prompt
 *           5. Security: Unified request header management Unified exception handling thread-safe singleton implementation
 *
 */
public abstract class BaseApiService<T> {
    protected T apiService;

    public BaseApiService() {
        apiService = HttpManager.getInstance().createApi(getApiServiceClass());
    }

    protected abstract Class<T> getApiServiceClass();

    protected <R> void executeRequest(Call<BaseResponse<R>> call, RequestCallback<R> callback) {
        if (callback != null) {
            callback.onStart();
        }

        call.enqueue(new Callback<BaseResponse<R>>() {
            @Override
            public void onResponse(Call<BaseResponse<R>> call, Response<BaseResponse<R>> response) {
                if (callback != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse<R> baseResponse = response.body();
                        if (baseResponse.isSuccess()) {
                            callback.onSuccess(baseResponse.getData());
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
            public void onFailure(Call<BaseResponse<R>> call, Throwable t) {
                if (callback != null) {
                    callback.onError(-1, t.getMessage());
                    callback.onComplete();
                }
            }
        });
    }
} 