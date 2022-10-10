package com.crowd.util;

import com.crowd.constant.CrowdConstant;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Mendax
 * @date 2022-10-09 20:44
 * 尚筹网工具类
 **/
public class CrowdUtil {


    /**
     * md5加密
     *
     * @param source 源（明文）字符串
     * @return 加密完成的字符串
     */
    public static String md5(String source) {

        // 1.判断 source 是否有效
        if (source == null || source.length() == 0) {
            // 2. 不是有效字符串抛出异常
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }

        // 3. MessageDigest 加密方法  algorithm:算法
        try {
            String algorithm = "md5";
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            // 4. 获取铭文字符串字节数组
            byte[] sourceBytes = source.getBytes(StandardCharsets.UTF_8);

            // 5. 执行加密
            byte[] out = digest.digest(sourceBytes);
            // 6. 创建 BigInteger 对象 sigNum: -1 for negative, 0 for zero, 1 for positive
            int sigNum = 1;
            BigInteger integer = new BigInteger(sigNum, out);
            // 7. 按16进制将 BigInteger值转为字符串
            int radix = 16;
            return integer.toString(radix).toUpperCase();
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
