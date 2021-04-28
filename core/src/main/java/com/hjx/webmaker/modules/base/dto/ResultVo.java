package com.hjx.webmaker.modules.base.dto;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("Rest调用通用返回对象")
public class ResultVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("错误码")
    private int code;
    @ApiModelProperty("提示信息")
    private String message;
    @ApiModelProperty("响应数据")
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + JSONObject.toJSONString(data) +
                '}';
    }
}
