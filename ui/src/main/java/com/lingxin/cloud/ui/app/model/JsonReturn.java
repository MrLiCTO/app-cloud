package com.lingxin.cloud.ui.app.model;

/**
 * Created by Mr_Li on 2016/8/31.
 */
public class JsonReturn {

    public final static String SUCCESS_CODE = "200";
    public final static String ERROR_CODE = "404";

    private String code;
    private String msg;
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
