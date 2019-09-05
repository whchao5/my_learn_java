package com.whchao.xmall.common.api;

public class Response<T> {

    private long code;
    private String message;
    private T data;


    protected Response() {}


    protected Response(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    protected Response(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Response<T> success(T data) {
        return new Response<>(ResultCode.SUCCESS, data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Response<T> successMessage(String message, T data) {
        return new Response<>(ResultCode.SUCCESS.getCode(), message, data);
    }


    /**
     * 参数验证失败返回结果
     */
    public static <T> Response<T> failed(T data) {
        return new Response<>(ResultCode.FAILED, data);
    }



    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> Response<T> validateFailed(String message) {
        return new Response<>(ResultCode.VALIDATE_FAILED.getCode(), message,  null);
    }


    /**
     * 未登录返回结果
     */
    public static <T> Response<T> unauthorized(T data) {
        return new Response<>(ResultCode.UNAUTHORIZED, data);
    }



    /**
     * 未授权返回结果
     */
    public static <T> Response<T> forbidden(T data) {
        return new Response<>(ResultCode.FORBIDDEN, data);
    }



    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
