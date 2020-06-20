package com.top.mayyd.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;

    static {
        //加载数据库连接池的配置文件
        final Properties properties = new Properties();
        final InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(is);

            ds = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getResource() {
        return ds;
    }
}
