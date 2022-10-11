package com.crowd.mvc.controller;

import com.crowd.constant.CrowdConstant;
import com.crowd.pojo.Admin;
import com.crowd.service.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Mendax
 * @date 2022-10-10 20:46
 **/
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/get/page.html")
    public String getPage(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            Model model
    ) {
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
        model.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
        return "admin-page";
    }

    /**
     * 退出登录
     *
     * @param session 会话
     * @return 界面
     */
    @RequestMapping("/admin/do/logout.html")
    public String doLogout(HttpSession session) {
        // session 强制失效
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }


    /**
     * 登陆方法
     *
     * @param loginAcct 用户名
     * @param userPswd  密码
     * @return 视图
     */
    @RequestMapping("/admin/do/login.html")
    public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPswd") String userPswd, HttpSession session) {

        // 1.返回Admin对象说明登陆成功，否则抛出异常
        Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);

        // 2. 登陆成功返回对象存入 session 域
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);
        return "redirect:/admin/to/main/page.html";
    }
}
