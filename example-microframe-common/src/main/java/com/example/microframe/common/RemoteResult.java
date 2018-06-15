package com.example.microframe.common;

/**
 * 远程调用返回封装
 *
 * @author fengshuonan
 * @date 2017-11-07-下午6:53
 */
public class RemoteResult<T> {

	/**
	 * 正常返回
	 */
	public static final int CODE_SUCCESS = 200;

	/**
	 * 失败
	 */
	public static final int CODE_FAILED = 500;
	
    private Integer code;

    private String message;

    private T body;

    public RemoteResult(){
    }

    public RemoteResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RemoteResult(Integer code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static <T> RemoteResult<T> success() {
        return new RemoteResult<T>(200, "操作成功!");
    }

    public static <T> RemoteResult<T> success(String msg) {
        return new RemoteResult<T>(200, msg);
    }

    public static <T> RemoteResult<T> success(Integer code, String msg) {
        return new RemoteResult<T>(code, msg);
    }

    public static <T> RemoteResult<T> success(T body) {
        return new RemoteResult<T>(200, "操作成功!", body);
    }

    public static <T> RemoteResult<T> error() {
        return new RemoteResult<T>(500, "操作失败!");
    }

    public static <T> RemoteResult<T> error(String msg) {
        return new RemoteResult<T>(500, msg);
    }

    public static <T> RemoteResult<T> error(Integer code, String msg) {
        return new RemoteResult<T>(code, msg);
    }

    public static <T> RemoteResult<T> error(T body) {
        return new RemoteResult<T>(500, "操作失败!", body);
    }

    public static <T> RemoteResult<T> error(Integer code, String msg, T body) {
        return new RemoteResult<T>(code, msg, body);
    }

}
