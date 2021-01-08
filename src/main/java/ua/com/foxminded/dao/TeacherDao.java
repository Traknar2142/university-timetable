package ua.com.foxminded.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.Teacher;
import ua.com.foxminded.rowmapper.TeacherRowMapper;

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

    public void update(long id, String newFirstName, String newLastName) {
        String sql = "UPDATE t_teachers SET first_name = ?, last_name = ? WHERE teacher_id = ?";
        jdbcTemplate.update(sql, newFirstName, newLastName, id);
    }

    public void deleteById(long id) {
        String sql = "DELETE FROM t_teachers WHERE teacher_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Teacher> getById(long id) {
        String sql = "SELECT* FROM t_teachers WHERE teacher_id = ?";
        return jdbcTemplate.query(sql, new Object[] { id }, new TeacherRowMapper());
    }
}
