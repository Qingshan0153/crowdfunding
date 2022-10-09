package com.crowd.mvc.controller;

import com.crowd.pojo.Admin;
import com.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author Mendax
 * @date 2022-10-09 15:52
 **/


@Controller
public class ControllerTest {

    @Autowired
    private AdminService adminService;


    @RequestMapping("/send/array/one.html")
    public String ajaxTestOne(@RequestParam("array[]") List<Integer> array) {
        for (Integer num : array) {
            System.out.println(num);
        }
        return "target";
    }


    @RequestMapping("/send/array/two.html")
    public String ajaxTestTwo(@RequestParam("array[]") List<Integer> array) {
        for (Integer num : array) {
            System.out.println(num);
        }
        return "target";
    }


    @RequestMapping("/test/ssm.html")
    public String ssmTest(Model model) {

        List<Admin> admins = adminService.getAll();
        model.addAttribute("admins", admins);

        return "target";
    }

}























