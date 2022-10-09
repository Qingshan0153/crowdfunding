package com.crowd.util;

/**
 * 统一整个项目中 Ajax 请求返回的结果 ( 也可用于分布式架构各个模块之间调用时返回的同一类型 )
 *
 * @param <T>
 */
public class ResultEntity<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    /**
     * 封装当前请求处理的结果: 成功/失败
     */
    private String result;

    /**
     * 请求处理失败时,返回的错误信息
     */
    private String message;

    /**
     * 要返回的数据
     */
    private T data;

    public ResultEntity() {
    }


    /**
     * 请求处理成功不需要返回数据使用的工具方法
     *
     * @param <Type> 消息类型
     * @return ResultEntity 消息实体
     */
    public static <Type> ResultEntity<Type> successWithOutData() {
        return new ResultEntity<>(SUCCESS, null, null);
    }

    /**
     * 请求处理成功需要返回数据使用的工具方法
     *
     * @param data   要返回的数据
     * @param <Type> 消息类型
     * @return ResultEntity 消息实体
     */
    public static <Type> ResultEntity<Type> successWithData(Type data) {
        return new ResultEntity<>(SUCCESS, null, data);
    }


    /**
     * 请求处理失败需要返回失败消息使用的工具方法
     *
     * @param message 消息内容
     * @param <Type>  消息类型
     * @return ResultEntity 消息实体
     */
    public static <Type> ResultEntity<Type> failed(String message) {
        return new ResultEntity<>(FAILED, message, null);
    }


    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }


    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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





































