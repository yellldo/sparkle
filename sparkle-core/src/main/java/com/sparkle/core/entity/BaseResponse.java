package com.sparkle.core.entity;

import cn.hutool.http.HttpStatus;

/**
 * ClassName : BaseResponse<br>
 * Description : 基础报文<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 */
public class BaseResponse {

    private String status = "0";
    private String message = "success";
    private int code = HttpStatus.HTTP_OK;

    public BaseResponse() {

    }

    public BaseResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String status, String message, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
