package ua.com.foxminded.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.models.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher> {

    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher();

        teacher.setId(rs.getLong(1));
        teacher.setFirstName(rs.getString(2));
        teacher.setLastName(rs.getString(3));
        return teacher;
    }
}
