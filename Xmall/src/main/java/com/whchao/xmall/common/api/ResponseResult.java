package com.whchao.xmall.common.api;

public class ResponseResult<T> {

    private long code;
    private String message;
    private T data;


    protected ResponseResult() {}


    protected ResponseResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    protected ResponseResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResultCode.SUCCESS, data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> successMessage(String message, T data) {
        return new ResponseResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }


    /**
     * 参数验证失败返回结果
     */
    public static <T> ResponseResult<T> failed(T data) {
        return new ResponseResult<>(ResultCode.FAILED, data);
    }



    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> ResponseResult<T> validateFailed(String message) {
        return new ResponseResult<>(ResultCode.VALIDATE_FAILED.getCode(), message,  null);
    }


    /**
     * 未登录返回结果
     */
    public static <T> ResponseResult<T> unauthorized(T data) {
        return new ResponseResult<>(ResultCode.UNAUTHORIZED, data);
    }



    /**
     * 未授权返回结果
     */
    public static <T> ResponseResult<T> forbidden(T data) {
        return new ResponseResult<>(ResultCode.FORBIDDEN, data);
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
