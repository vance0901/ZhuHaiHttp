package com.vance0901.zhuhai.network.http.callback;

/**
 * 网络请求回调接口 Network request callback interface
 * @param <T> 响应数据类型 Response data type
 */
public interface RequestCallback<T> {
    void onStart();
    void onSuccess(T data);
    void onError(int code, String message);
    void onComplete();
} 