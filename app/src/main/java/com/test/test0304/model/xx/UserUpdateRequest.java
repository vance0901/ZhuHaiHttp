package com.test.test0304.model.xx;

/**
 * 用户信息更新请求模型
 */
public class UserUpdateRequest {
    private String address;
    private String birth;
    private String phone;
    private String region;
    private int sex;
    private int userId;
    private String userName;
    private String verifyCode;
    
    public UserUpdateRequest() {
        // 默认构造方法
    }
    
    // 链式构建器设计模式
    public static class Builder {
        private final UserUpdateRequest request;
        
        public Builder() {
            request = new UserUpdateRequest();
        }
        
        public Builder address(String address) {
            request.address = address;
            return this;
        }
        
        public Builder birth(String birth) {
            request.birth = birth;
            return this;
        }
        
        public Builder phone(String phone) {
            request.phone = phone;
            return this;
        }
        
        public Builder region(String region) {
            request.region = region;
            return this;
        }
        
        public Builder sex(int sex) {
            request.sex = sex;
            return this;
        }
        
        public Builder userId(int userId) {
            request.userId = userId;
            return this;
        }
        
        public Builder userName(String userName) {
            request.userName = userName;
            return this;
        }
        
        public Builder verifyCode(String verifyCode) {
            request.verifyCode = verifyCode;
            return this;
        }
        
        public UserUpdateRequest build() {
            return request;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    
    @Override
    public String toString() {
        return "UserUpdateRequest{" +
                "address='" + address + '\'' +
                ", birth='" + birth + '\'' +
                ", phone='" + phone + '\'' +
                ", region='" + region + '\'' +
                ", sex=" + sex +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
} 