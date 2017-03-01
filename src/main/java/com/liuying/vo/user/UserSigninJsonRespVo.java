package com.liuying.vo.user;

/**
 * Created by luo on 27/02/2017.
 */
public class UserSigninJsonRespVo{
    private String isLegal;  // 标示是否验证成功
    private String signInMessage;  // 如果验证没成功,给出错误提示

    public static final String LEGAL = "YES";
    public static final String ILLEGAL = "NO";

    public UserSigninJsonRespVo() {}

    public UserSigninJsonRespVo(String isLegal, String signInMessage) {
        this.isLegal = isLegal;
        this.signInMessage = signInMessage;
    }

    public String getIsLegal() {
        return isLegal;
    }

    public void setIsLegal(String isLegal) {
        this.isLegal = isLegal;
    }

    public String getSignInMessage() {
        return signInMessage;
    }

    public void setSignInMessage(String signInMessage) {
        this.signInMessage = signInMessage;
    }
}
