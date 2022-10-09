package com.crowd;

import com.crowd.mappers.AdminMapper;
import com.crowd.pojo.Admin;
import com.crowd.service.AdminService;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mendax
 * @date 2022-10-08 21:02
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;


    @Test
    public void serviceTest() {
        Admin admin = new Admin(null, "lina", "lina", "lina", "lina@163.com", null);
        adminService.saveAdmin(admin);
    }


    @Test
    public void getConnectionTest() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }

    @Test
    public void adminMapperTest() {
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }


}




















