package com.test.test0304.model.xx;

/**
 * 登录请求模型
 */
public class LoginRequest {
    private String phone;
    private String verifyCode;
    
    public LoginRequest() {
    }
    
    public LoginRequest(String phone, String verifyCode) {
        this.phone = phone;
        this.verifyCode = verifyCode;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getVerifyCode() {
        return verifyCode;
    }
    
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    
    @Override
    public String toString() {
        return "LoginRequest{" +
                "phone='" + phone + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
} 