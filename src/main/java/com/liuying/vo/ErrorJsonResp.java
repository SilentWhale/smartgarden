package com.liuying.vo;

/**
 * Created by luo on 27/02/2017.
 */
public class ErrorJsonResp {
//    int errorCode;
    private String errorMessage;

    public ErrorJsonResp() {
    }

    public ErrorJsonResp(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorJsonResp{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
