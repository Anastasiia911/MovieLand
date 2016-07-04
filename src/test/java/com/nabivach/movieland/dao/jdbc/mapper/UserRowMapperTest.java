package com.nabivach.movieland.dao.jdbc.mapper;
import com.nabivach.movieland.entity.User;
import junit.framework.TestCase;
import java.sql.ResultSet;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRowMapperTest extends TestCase {

    public void testMapRow() throws Exception {
//prepare
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("name")).thenReturn("VASYA");
        when(rs.getString("email")).thenReturn("VASYA@GMAIL.COM");
        when(rs.getString("pass")).thenReturn("000");
        UserRowMapper userRowMapper = new UserRowMapper();
      User user = userRowMapper.mapRow(rs, 1);
//test
        assertEquals(1,user.getUserId());
        assertEquals("VASYA",user.getName());
        assertEquals("VASYA@GMAIL.COM", user.getLogin());
        assertEquals("000",user.getPassword());
    }
}