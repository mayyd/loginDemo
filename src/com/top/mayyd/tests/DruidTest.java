package com.top.mayyd.tests;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.top.mayyd.domain.User;
import com.top.mayyd.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest {
    @Test
    public void testConnect() throws Exception {
        final Properties properties = new Properties();
        //从 properties 中加载配置
        InputStream is = DruidTest.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(is);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM user WHERE user = ?";
        final User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(), "zuji");



    }
}
