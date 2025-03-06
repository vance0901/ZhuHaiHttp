package com.vance0901.zhuhai.network.http.model;

/**
 * 网络响应基类
 * @param <T> 具体的数据类型
 */
public class BaseResponse<T> {
    private int errorCode;
    private String errorMsg;
    private T data;

    public boolean isSuccess() {
        return errorCode == 0;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
} 