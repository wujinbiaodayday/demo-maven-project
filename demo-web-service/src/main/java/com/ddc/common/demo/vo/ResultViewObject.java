package com.ddc.common.demo.vo;

import java.io.Serializable;

/**
 * 返回结果集
 *
 * @author mumu.li
 */
public class ResultViewObject<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer total;
    private T rows;

    private T result;
    //0-成功，非0(自定义)失败
    private Integer code;

    private String defaultMessage;

    public ResultViewObject() {
    }

    public ResultViewObject(T rows, Integer total) {
        this.rows = rows;
        this.total = total;
    }

    public ResultViewObject(T result, Integer code, String defaultMessage) {
        this.result = result;
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public static <T> ResultViewObject success(T result) {
        return new ResultViewObject(result, 0, "success");
    }

    public static <T> ResultViewObject success(T rows, Integer total) {
        return new ResultViewObject(rows, total);
    }

    public static <T> ResultViewObject success(T result, Integer code, String defaultMessage) {
        return new ResultViewObject(result, code, defaultMessage);
    }

    public static <T> ResultViewObject fail() {
        return new ResultViewObject(null, 1, "程序病倒了，医生正在路上");
    }

    public static <T> ResultViewObject fail(String defaultMessage) {
        return new ResultViewObject(null, 1, defaultMessage);
    }

    public static <T> ResultViewObject fail(T result, Integer code, String defaultMessage) {
        return new ResultViewObject(result, code, defaultMessage);
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
