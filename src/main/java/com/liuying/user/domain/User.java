package com.liuying.user.domain;

/**
 * Created by luo on 22/02/2017.
 */
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private int userRight;
    private String userSex;
    private String userMail;
    private String userPhone;
    private int userAge;
    private int userHis;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRight=" + userRight +
                ", userSex='" + userSex + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAge=" + userAge +
                ", userHis=" + userHis +
                '}';
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserRight() {
        return userRight;
    }

    public void setUserRight(int userRight) {
        this.userRight = userRight;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserHis() {
        return userHis;
    }

    public void setUserHis(int userHis) {
        this.userHis = userHis;
    }
}
