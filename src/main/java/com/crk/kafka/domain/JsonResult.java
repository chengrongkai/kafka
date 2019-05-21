package com.crk.kafka.domain;

import java.io.Serializable;

public class JsonResult implements Serializable{
    private Integer success;

    private String message;

    private Object data;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult(Integer success, String message,Object data){
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
