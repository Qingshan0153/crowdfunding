package com.crowd.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Mendax
 * @date 2022-10-09 20:44
 **/
public class CrowdUtil {

    /**
     * 判断当前请求是否为 ajax 请求
     *
     * @param request request请求对象
     * @return true:是Ajax请求 false: 不是Ajax请求     
     */
    public static boolean judgeRequestType(HttpServletRequest request) {

        // 1. 获取请求消息头
        String accept = request.getHeader("Accept");
        String header = request.getHeader("X-Request-With");

        return (accept != null && accept.contains("application/json") ||
                "XMLHttpRequest".equals(header));
    }
}
