package ua.com.foxminded.universityTimetable.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.universityTimetable.models.Teacher;
import ua.com.foxminded.universityTimetable.rowmapper.TeacherRowMapper;

@Repository
public class TeacherDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Long add(Teacher teacher) {
        String sql = "INSERT INTO t_teachers(first_name, last_name) VALUES(?,?) RETURNING teacher_id";
        String firstName = teacher.getFirstName();
        String lastName = teacher.getLastName();

        long teacherId = jdbcTemplate.queryForObject(sql, new Object[] { firstName, lastName }, Long.class);
        return teacherId;
    }

    public Boolean update(long id, String newFirstName, String newLastName) {
        int rowCount = 0;
        String sql = "UPDATE t_teachers SET first_name = ?, last_name = ? WHERE teacher_id = ?";

        rowCount = jdbcTemplate.update(sql, newFirstName, newLastName, id);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public Boolean delete(long id) {
        int rowCount = 0;
        String sql = "DELETE FROM t_teachers WHERE teacher_id = ?";

        rowCount = jdbcTemplate.update(sql, id);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public List<Teacher> getById(long id) {
        String sql = "SELECT* FROM t_teachers WHERE teacher_id = ?";
        return jdbcTemplate.query(sql, new Object[] { id }, new TeacherRowMapper());
    }
}
