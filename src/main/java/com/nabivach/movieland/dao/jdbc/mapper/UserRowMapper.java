package com.nabivach.movieland.dao.jdbc.mapper;

import com.nabivach.movieland.entity.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int i) throws SQLException {

        User user = new User();
        user.setUserId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setLogin(rs.getString("email"));
        user.setPassword(rs.getString("pass"));
        return user;
    }
}
