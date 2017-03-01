package com.liuying.vo;


/**
 * Created by luo on 27/02/2017.
 */
public class JsonRespVo<T> {
    private String status;
    private T data;
    private ErrorJsonResp error;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorJsonResp getError() {
        return error;
    }

    public void setError(ErrorJsonResp error) {
        this.error = error;
    }
}
