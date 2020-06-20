package com.top.mayyd.dao;

import com.top.mayyd.domain.User;
import com.top.mayyd.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getResource());

    public User login(User loginUser) {
        try {
            String sql = "SELECT * FROM user WHERE username = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername());
            return user;
        } catch (DataAccessException e) {
            System.out.println("未查询到符号条件的数据");
            return null;
        }
    }
}
