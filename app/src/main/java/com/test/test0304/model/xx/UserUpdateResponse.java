package com.test.test0304.model.xx;

/**
 * 用户信息更新响应模型
 */
public class UserUpdateResponse {
    private boolean success;
    private String message;
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return "UserUpdateResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
} 