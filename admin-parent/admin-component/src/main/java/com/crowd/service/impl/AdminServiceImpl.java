package com.crowd.service.impl;

import com.crowd.constant.CrowdConstant;
import com.crowd.exception.LoginFailedException;
import com.crowd.mappers.AdminMapper;
import com.crowd.pojo.Admin;
import com.crowd.pojo.AdminExample;
import com.crowd.service.AdminService;
import com.crowd.util.CrowdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {
        // 1. 根据登录账号查询 admin对象
        AdminExample example = new AdminExample();
        example.createCriteria().andLoginAcctEqualTo(loginAcct);

        List<Admin> admins = adminMapper.selectByExample(example);

        // 2. 判断admin 对象是否为空（为空抛出异常）

        if (admins == null || admins.size() == 0) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        if (admins.size() > 1) {
            throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NAME_UNIQUE);
        }
        Admin admin = admins.get(0);
        if (admin == null) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);

        }
        // 3. admin 不为空从将数据库密码从 admin 对象中取出
        String pwdDb = admin.getUserPswd();
        // 4. 将表单提交明文密码加密
        String pwdFrom = CrowdUtil.md5(userPswd);
        // 5. 对密码进行比较
        if (!Objects.equals(pwdDb, pwdFrom)) {
            // 6. 接获不一致抛出异常
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);

        }
        // 7. 账号密码一致返回 admin
        return admin;
    }

    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminMapper.selectAdminByKeyWord(keyword);
        // 5:导航分页页码数
        return new PageInfo<>(admins, 5);
    }

}
