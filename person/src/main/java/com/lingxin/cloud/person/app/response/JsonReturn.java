package com.lingxin.cloud.person.app.response;

/**
 * Created by Mr_Li on 2016/8/31.
 */
public class JsonReturn {

    public final static Integer SUCCESS_CODE = 200;
    public final static Integer ERROR_CODE = 404;

    private Integer code;
    private String msg;
    private String data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
