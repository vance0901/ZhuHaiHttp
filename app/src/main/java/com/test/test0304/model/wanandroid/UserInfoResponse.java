package com.test.test0304.model.wanandroid;

/**
 * WanAndroid 用户信息响应数据
 */
public class UserInfoResponse {
    private CoinInfo coinInfo;
    private CollectArticleInfo collectArticleInfo;
    private UserDetailInfo userInfo;

    public CoinInfo getCoinInfo() {
        return coinInfo;
    }

    public void setCoinInfo(CoinInfo coinInfo) {
        this.coinInfo = coinInfo;
    }

    public CollectArticleInfo getCollectArticleInfo() {
        return collectArticleInfo;
    }

    public void setCollectArticleInfo(CollectArticleInfo collectArticleInfo) {
        this.collectArticleInfo = collectArticleInfo;
    }

    public UserDetailInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserDetailInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserInfoResponse{" +
                "coinInfo=" + coinInfo +
                ", collectArticleInfo=" + collectArticleInfo +
                ", userInfo=" + userInfo +
                '}';
    }
} 