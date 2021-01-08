package ua.com.foxminded.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.models.Classroom;

public class ClassroomRowMapper implements RowMapper<Classroom> {

    @Override
    public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
        Classroom classroom = new Classroom();

        classroom.setId(rs.getLong(1));
        classroom.setRoomNumber(rs.getInt(2));
        return classroom;
    }
}
