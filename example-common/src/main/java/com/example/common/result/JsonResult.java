package com.example.common.result;

import java.io.Serializable;

/**
 * 封装前端调用结果集
 */
public class JsonResult<T>  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Boolean success = false;          // 返回是否成功
    private String msg = "";                  // 返回信提示，可用于前端显示
    private String detail = "";               // 返回信息详情，保存不便于前端展示的内容
    private T obj = null;                     // 返回其他对象信息

    public JsonResult() {
    }

    public JsonResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public JsonResult(Boolean success, String msg, T obj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }

    public JsonResult(Boolean success, String msg, String detail) {
        this.success = success;
        this.msg = msg;
        this.detail = detail;
    }

    public JsonResult(Boolean success, String msg, String detail, T obj) {
        this.success = success;
        this.msg = msg;
        this.detail = detail;
        this.obj = obj;
    }

    //---------------------------------- 返回成功 -----------------------------------------

    public static <T> JsonResult<T> resultSuccess() {
        return resultSuccess("操作成功", null);
    }

    public static <T> JsonResult<T> resultSuccess(T obj) {
        return resultSuccess("操作成功", obj);
    }

    public static <T> JsonResult<T> resultSuccess(String message, T obj) {
        return new JsonResult<T>(true, message, obj);
    }

    public static <T> JsonResult<T> resultSuccess(String message, String detail, T obj) {
        return new JsonResult<T>(true, message, detail, obj);
    }



    //---------------------------------- 返回失败 -----------------------------------------

    public static <T> JsonResult<T> resultError() {
        return new JsonResult<T>(false, "网络异常");
    }

    public static <T> JsonResult<T> resultError(String message) {
        return new JsonResult<T>(false, message);
    }

    public static <T> JsonResult<T> resultError(String message, String detail) {
        return new JsonResult<T>(false, message, detail);
    }

    public static <T> JsonResult<T> resultError(String message, String detail, T obj) {
        return new JsonResult<T>(false, message, detail, obj);
    }

    /**
     * 当异常类型为BizException时，返回异常信息，否则返回默认信息
     * 
     * @param e
     * @param defaultErrorMessage
     * @return
     */
    public static <T> JsonResult<T> resultExceptionError(Exception e, String defaultErrorMessage) {
    	if(e instanceof RuntimeException){
    		return new JsonResult<T>(false, e.getMessage());
    	}
    	
        return new JsonResult<T>(false, defaultErrorMessage);
    }




    /**----------------------------------- get set method -----------------------------------**/

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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
