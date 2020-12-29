package ua.com.foxminded.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LessonOnTimeTableDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertLessonOnTimeTable(int subjectId, int classroomId, int teacherId) {
        String sql = "INSERT INTO t_lesson_on_time_table(subject_id, classroom_id, teacher_id) VALUES (?,?,?)";
        jdbcTemplate.update(sql, subjectId, classroomId, teacherId);
    }

    public void deleteLessonOnTimeTableById(int id) {
        String sql = "DELETE FROM t_lesson_on_time_table WHERE lesson_on_table_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
