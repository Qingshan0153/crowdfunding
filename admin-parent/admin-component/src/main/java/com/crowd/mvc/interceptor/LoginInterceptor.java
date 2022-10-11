package com.crowd.mvc.interceptor;

import com.crowd.constant.CrowdConstant;
import com.crowd.exception.AccessForbiddenException;
import com.crowd.pojo.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mendax
 * @version 2022-10-11 19:21
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. 判断会话中是否有登陆对象
        Admin loginAdmin = (Admin) request.getSession().getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);

        // 2. 判断
        if (loginAdmin == null) {
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_LOGIN_AFTER);
        }

        // 如果admin对象不为空，放行
        return true;

    }
}
