package com.jqq.exception;


import com.jqq.enums.ResultEnum;

/**
 * Created by lql on 2017/02/12.
 */
public class JqqException extends RuntimeException{
    private Integer code;

    public JqqException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
