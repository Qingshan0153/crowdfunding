package com.crowd.service.impl;

import com.crowd.mappers.AdminMapper;
import com.crowd.pojo.Admin;
import com.crowd.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mendax
 * @date 2022-10-09 14:11
 **/

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
}
