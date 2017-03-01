package com.liuying.vo.user;


/**
 * Created by luo on 27/02/2017.
 */
public class UserSigninJsonReqVo {
    private String signInKey;

    private String signInPasswd;

    private String signInType;

    @Override
    public String toString() {
        return "UserSigninJsonReqVo{" +
                "signInKey='" + signInKey + '\'' +
                ", signInPasswd='" + signInPasswd + '\'' +
                ", signInType='" + signInType + '\'' +
                '}';
    }

    public String getSignInKey() {
        return signInKey;
    }

    public void setSignInKey(String signInKey) {
        this.signInKey = signInKey;
    }

    public String getSignInPasswd() {
        return signInPasswd;
    }

    public void setSignInPasswd(String signInPasswd) {
        this.signInPasswd = signInPasswd;
    }

    public String getSignInType() {
        return signInType;
    }

    public void setSignInType(String signInType) {
        this.signInType = signInType;
    }
}
