package ua.com.foxminded.universityTimetable.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.universityTimetable.models.Subject;

public class SubjectRowMapper implements RowMapper<Subject> {

    @Override
    public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subject subject = new Subject();

        subject.setId(rs.getLong(1));
        subject.setSubjectName(rs.getString(2));
        return subject;
    }
}
