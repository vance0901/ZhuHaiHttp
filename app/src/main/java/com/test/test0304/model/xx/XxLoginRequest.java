package com.test.test0304.model.xx;

/**
 * x业xxxxx登录请求数据模型
 */
public class XxLoginRequest {
    private String phone;
    private String verifyCode;
    
    public XxLoginRequest() {
    }
    
    public XxLoginRequest(String phone, String verifyCode) {
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
        return "XxLoginRequest{" +
                "phone='" + phone + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
} 