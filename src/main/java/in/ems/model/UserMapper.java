package in.ems.model;

import in.ems.utils.CommonConstants;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(CommonConstants.ID));
        user.setUserId(rs.getString(CommonConstants.USER_ID));
        user.setRole(rs.getInt(CommonConstants.ROLE));
        user.setPassword(rs.getString(CommonConstants.PASSWORD));
        return user;
    }

}
