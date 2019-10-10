package com.zq.service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ResBean<T> implements Serializable {
    public int code;
    public String msg;
    public List<T> res = Collections.emptyList();

    private ResBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResBean(int code, String msg, List<T> res) {
        this.code = code;
        this.msg = msg;
        this.res = res;
    }

    public static <E> ResBean succWithRes(List<E> res) {
        return new ResBean<E>(200, "成功", res);
    }

    public static ResBean succ() {
        return new ResBean(200, "成功");
    }

    public static ResBean err(String msg) {
        return new ResBean(-1, msg);
    }

    @Override
    public String toString() {
        return "{\"code\":\"" + code + "\",\"msg\":\"" + msg + "\",\"res\":"+res.toString()+"}";
    }
}
