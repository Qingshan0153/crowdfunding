package com.crowd.mvc.controller;

import com.crowd.pojo.Admin;
import com.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author Mendax
 * @date 2022-10-09 15:52
 **/


@Controller
public class ControllerTest {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/test/ssm.html")
    public String ssmTest(Model model) {

        List<Admin> admins = adminService.getAll();
        model.addAttribute("admins", admins);

        return "target";
    }

}























