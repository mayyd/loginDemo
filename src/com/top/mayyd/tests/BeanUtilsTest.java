package com.top.mayyd.tests;

import com.top.mayyd.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class BeanUtilsTest {
    @Test
    public void testBeanUtils() throws Exception {
        User user = new User();
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "张三");
        map.put("password", "123456");

        BeanUtils.populate(user, map);

        Assert.assertEquals("张三", user.getUsername());
        Assert.assertEquals("123456", user.getPassword());
    }
}
