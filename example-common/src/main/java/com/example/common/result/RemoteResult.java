package com.example.common.result;

import java.io.Serializable;

/**
 * 封装服务间调用结果集
 */
public class RemoteResult<T>  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code = 500;          // 返回是否成功
    private String msg = "";             // 返回信提示，可用于前端显示
    private String detail = "";          // 返回信息详情，保存不便于前端展示的内容
    private T obj = null;                // 返回其他对象信息

    public RemoteResult() {
    }

    public RemoteResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RemoteResult(Integer code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public RemoteResult(Integer code, String msg, String detail) {
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }

    public RemoteResult(Integer code, String msg, String detail, T obj) {
        this.code = code;
        this.msg = msg;
        this.detail = detail;
        this.obj = obj;
    }

    //---------------------------------- 返回成功 -----------------------------------------

    public static <T> RemoteResult<T> resultcode() {
        return resultcode("操作成功", null);
    }

    public static <T> RemoteResult<T> resultcode(T obj) {
        return resultcode("操作成功", obj);
    }

    public static <T> RemoteResult<T> resultcode(String message, T obj) {
        return new RemoteResult<T>(200, message, obj);
    }

    public static <T> RemoteResult<T> resultcode(String message, String detail, T obj) {
        return new RemoteResult<T>(200, message, detail, obj);
    }



    //---------------------------------- 返回失败 -----------------------------------------

    public static <T> RemoteResult<T> resultError() {
        return new RemoteResult<T>(500, "网络异常");
    }

    public static <T> RemoteResult<T> resultError(String message) {
        return new RemoteResult<T>(500, message);
    }

    public static <T> RemoteResult<T> resultError(String message, String detail) {
        return new RemoteResult<T>(500, message, detail);
    }

    public static <T> RemoteResult<T> resultError(String message, String detail, T obj) {
        return new RemoteResult<T>(500, message, detail, obj);
    }

    /**
     * 当异常类型为BizException时，返回异常信息，否则返回默认信息
     *
     * @param e
     * @param defaultErrorMessage
     * @return
     */
    public static <T> RemoteResult<T> resultExceptionError(Exception e, String defaultErrorMessage) {
        if(e instanceof RuntimeException){
            return new RemoteResult<T>(500, e.getMessage());
        }

        return new RemoteResult<T>(500, defaultErrorMessage);
    }




    /**----------------------------------- get set method -----------------------------------**/

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
