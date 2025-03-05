package com.test.test0304.model.wanandroid;

/**
 * WanAndroid 用户积分信息
 */
public class CoinInfo {
    private int coinCount;
    private int level;
    private String nickname;
    private String rank;
    private int userId;
    private String username;

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CoinInfo{" +
                "coinCount=" + coinCount +
                ", level=" + level +
                ", rank='" + rank + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
} 