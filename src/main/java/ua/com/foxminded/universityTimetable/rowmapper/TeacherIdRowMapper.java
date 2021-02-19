package ua.com.foxminded.universityTimetable.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TeacherIdRowMapper implements RowMapper<Long> {

    @Override
    public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
        long teacherId = rs.getLong(1);
        return teacherId;
    }

}
