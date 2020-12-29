package ua.com.foxminded.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.DayOfWeek;

@Repository
public class DayOfWeekDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertDayOfWeek(DayOfWeek dayOfWeek) {
        String sql = "INSERT INTO t_day_of_week(name_of_day) VALUES (?)";
        jdbcTemplate.update(sql, dayOfWeek.getNameOfDay());
    }

    public void deleteDayOfWeekById(int id) {
        String sql = "DELETE FROM t_day_of_week WHERE t_day_of_week = ?";
        jdbcTemplate.update(sql, id);
    }

    public void assignLessonOnTimeForDayOfWeek(int dayOfWeekId, int lessonOnTimeTableId) {
        String sql = "INSERT INTO t_day_of_week_lesson_on_table_relation(day_of_week_id, lesson_on_time_table_id) VALUES(?, ?)";
        jdbcTemplate.update(sql, dayOfWeekId, lessonOnTimeTableId);
    }

    public void removeLessonOnTimeForDayOfWeek(int dayOfWeekId, int lessonOnTimeTableId) {
        String sql = "DELETE FROM t_day_of_week_lesson_on_table_relation WHERE day_of_week_id = ? , lesson_on_time_table_id = ?";
        jdbcTemplate.update(sql, dayOfWeekId, lessonOnTimeTableId);
    }
}
