package com.crowd.util;

import com.crowd.constant.CrowdConstant;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Mendax
 * @date 2022-10-09 20:44
 **/
public class CrowdUtil {


    public static String md5(String source) {

        // 1.判断 source 是否有效
        if (source == null || source.length() == 0) {
            // 2. 不是有效字符串抛出异常
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }

        // 3. MessageDigest 加密方法  algorithm:算法
        String algorithm = "md5";
        try {
            MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


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
