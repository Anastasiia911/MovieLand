package com.nabivach.movieland.dao.jdbc;

import com.nabivach.movieland.dao.UserDao;
import com.nabivach.movieland.dao.jdbc.mapper.UserRowMapper;
import com.nabivach.movieland.dto.Credentials;
import com.nabivach.movieland.entity.User;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserDao implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcUserDao.class);
    @Autowired
    private String getUserByCredentials;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private UserRowMapper userRowMapper = new UserRowMapper();

    @Override
    public User getUserByCredentials(Credentials userCredentials) {
        String mail = userCredentials.getMail();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("email", mail);
        LOGGER.debug("Start getting user from DB by mail {}", mail);
        User user = jdbcTemplate.queryForObject(getUserByCredentials, parameterSource, userRowMapper);

        LOGGER.debug("Finishing getting user from DB by mail {}", mail);
        return user;
    }
}
