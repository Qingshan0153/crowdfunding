package com.crowd.utils;

import com.crowd.util.CrowdUtil;
import org.junit.Test;

/**
 * @author Mendax
 * @date 2022-10-10 22:20
 **/
public class UtilsTest {

    @Test
    public void md5Test(){
        String source="admin";
        String s = CrowdUtil.md5(source);
        System.out.println("s = " + s);
    }
}
