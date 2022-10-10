package com.crowd.mvc.config;

import com.crowd.constant.CrowdConstant;
import com.crowd.util.CrowdUtil;
import com.crowd.util.ResultEntity;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ControllerAdvice 表示当前类是基于注解的异常处理类
 *
 * @author 青衫
 */
@ControllerAdvice
public class CrowdExceptionResolver {


    /**
     * 空指针异常映射
     *
     * @param exception 异常类型
     * @param request   请求对象
     * @param response  返回对象
     * @return 视图模型
     * @throws IOException IO 异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointerException(NullPointerException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String viewName = "system-error";

        return commonResolve(exception, viewName, request, response);
    }


    /**
     * 异常映射通用方法
     *
     * @param exception 异常类型
     * @param request   请求对象
     * @param viewName  异常处理后指定去的页面
     * @param response  返回对象
     * @return 视图模型
     * @throws IOException IO 异常
     */
    private ModelAndView commonResolve(Exception exception, String viewName, HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 获取异常消息
        String message = exception.getMessage();

        // 判断当前请求类型
        boolean requestType = CrowdUtil.judgeRequestType(request);

        // 是 ajax 请求
        if (requestType) {
            // 创建消息类型对象
            ResultEntity<Object> failed = ResultEntity.failed(message);
            // 转为 json串
            Gson gson = new Gson();
            String json = gson.toJson(failed);
            // 通过原生response对象，响应至浏览器，返回空对象
            response.getWriter().write(json);
            return null;
        }

        // 不是ajax 对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);
        modelAndView.setViewName(viewName);
        // 返回 modelAndView 对象
        return modelAndView;
    }

}
