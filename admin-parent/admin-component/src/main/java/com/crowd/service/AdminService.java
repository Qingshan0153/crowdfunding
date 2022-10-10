package com.crowd.service;

import com.crowd.pojo.Admin;

import java.util.List;

/**
 * @author Mendax
 * @date 2022-10-09 14:10
 **/


public interface AdminService {

    /**
     * 新增用户保存
     *
     * @param admin 用户
     */
    void saveAdmin(Admin admin);

    /**
     * 返回所有用户
     *
     * @return 用户集合
     */
    List<Admin> getAll();

    /**
     * 根据用户名密码登录
     *
     * @param loginAcct 用户名
     * @param userPswd  密码
     * @return 用户对象
     */
    Admin getAdminByLoginAcct(String loginAcct, String userPswd);
}
