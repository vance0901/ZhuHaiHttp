package com.test.test0304.model.xx;

/**
 * x业xxxxx登录响应数据模型
 */
public class XxLoginResponse {
    private int code;
    private String msg;
    
    public int getToken() {
        return code;
    }
    
    public void setToken(int token) {
        this.code = token;
    }
    
    public String getmsg() {
        return msg;
    }
    
    public void setmsg(String msg) {
        this.msg = msg;
    }
    
    @Override
    public String toString() {
        return "XxLoginResponse{" +
                "code='" + code + '\'' +
                ", msg=" + msg +
                '}';
    }
    
    /**
     * 用户信息类
     */
    public static class UserInfo {
        private String userId;
        private String username;
        private String phone;
        private String avatar;
        
        public String getUserId() {
            return userId;
        }
        
        public void setUserId(String userId) {
            this.userId = userId;
        }
        
        public String getUsername() {
            return username;
        }
        
        public void setUsername(String username) {
            this.username = username;
        }
        
        public String getPhone() {
            return phone;
        }
        
        public void setPhone(String phone) {
            this.phone = phone;
        }
        
        public String getAvatar() {
            return avatar;
        }
        
        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
        
        @Override
        public String toString() {
            return "UserInfo{" +
                    "userId='" + userId + '\'' +
                    ", username='" + username + '\'' +
                    ", phone='" + phone + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }
} 