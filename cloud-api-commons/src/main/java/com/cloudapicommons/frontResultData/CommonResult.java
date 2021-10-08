package com.cloudapicommons.frontResultData;

public class CommonResult <T>{

    private Integer coed;
    private String message;
    private T data;

    public CommonResult(Integer coed, String message, T data) {
        this.coed = coed;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer coed, String message) {
        this.coed = coed;
        this.message = message;
    }

    public CommonResult() {
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "coed=" + coed +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCoed() {
        return coed;
    }

    public void setCoed(Integer coed) {
        this.coed = coed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
