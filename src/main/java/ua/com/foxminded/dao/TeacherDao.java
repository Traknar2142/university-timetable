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

    public void insertTeacher(Teacher teacher) {
        String sql = "INSERT INTO t_teachers(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(sql, teacher.getFirstName(), teacher.getLastName());
    }

    public void updateTeacher(int id, String newFirstName, String newLastName) {
        String sql = "UPDATE t_teachers SET first_name = ?, last_name = ? WHERE teacher_id = ?";
        jdbcTemplate.update(sql, newFirstName, newLastName, id);
    }

    public void deleteTeacherById(int id) {
        String sql = "DELETE FROM t_teachers WHERE teacher_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Teacher> getTeacherById(int id) {
        String sql = "SELECT* FROM t_teachers WHERE teacher_id = '" + id + "'";
        return jdbcTemplate.query(sql, new TeacherRowMapper());
    }
}
