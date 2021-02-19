package ua.com.foxminded.universityTimetable.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.universityTimetable.models.Group;

public class GroupRowMapper implements RowMapper<Group> {

    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        Group group = new Group();
        group.setId(rs.getLong(1));
        group.setGroupName(rs.getString(2));
        return group;
    }
}
