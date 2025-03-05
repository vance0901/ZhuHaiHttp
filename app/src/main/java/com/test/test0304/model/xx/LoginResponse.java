package com.test.test0304.model.xx;

/**
 * 登录响应模型
 */
public class LoginResponse {
    private String token;
    private UserInfo userInfo;
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public UserInfo getUserInfo() {
        return userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
    
    /**
     * 用户信息
     */
    public static class UserInfo {
        private String userId;
        private String userName;
        private String phone;
        
        public String getUserId() {
            return userId;
        }
        
        public void setUserId(String userId) {
            this.userId = userId;
        }
        
        public String getUserName() {
            return userName;
        }
        
        public void setUserName(String userName) {
            this.userName = userName;
        }
        
        public String getPhone() {
            return phone;
        }
        
        public void setPhone(String phone) {
            this.phone = phone;
        }
        
        @Override
        public String toString() {
            return "UserInfo{" +
                    "userId='" + userId + '\'' +
                    ", userName='" + userName + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }
} 