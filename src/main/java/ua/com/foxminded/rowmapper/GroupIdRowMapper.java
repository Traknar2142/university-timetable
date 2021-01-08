package ua.com.foxminded.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GroupIdRowMapper implements RowMapper<Long>{

    @Override
    public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long groupId = rs.getLong(1);
        return groupId;
    }

}
