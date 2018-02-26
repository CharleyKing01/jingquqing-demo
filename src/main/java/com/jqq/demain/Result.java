package com.jqq.demain;

import java.util.HashMap;
import java.util.Map;

/**
 *  @author：linqiaoli
 *  @Date 2018/2/12 14:13
 *  @Description：
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static final int code_ok = 1;
    public static final int code_unknow_error = 98;
    public static final int code_user_not_exist = 97;
    public static final int code_biz_error = 96;

    private Result() {
        put("ok", true);
        put("code", code_ok);
    }

    public static Result error() {
        return error(code_unknow_error, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(code_unknow_error, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("ok", false);
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}