package ua.com.foxminded.universityTimetable.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.universityTimetable.models.DayOfWeek;

@Repository
public class TimeTableDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Long addLessonOnTimeTable(long subjectId, long classroomId, long teacherId) {
        String sql = "INSERT INTO t_lesson_on_time_table(subject_id, classroom_id, teacher_id) VALUES (?,?,?) RETURNING lesson_on_table_id";

        long lessonOnTimeTableId = jdbcTemplate.queryForObject(sql, new Object[] { subjectId, classroomId, teacherId },
                Long.class);
        return lessonOnTimeTableId;
    }

    public Boolean deleteLessonOnTimeTableById(long id) {
        int rowCount = 0;
        String sql = "DELETE FROM t_lesson_on_time_table WHERE lesson_on_table_id = ?";
        rowCount = jdbcTemplate.update(sql, id);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public Long addDayOfWeek(DayOfWeek dayOfWeek) {
        String sql = "INSERT INTO t_day_of_week(name_of_day) VALUES (?) RETURNING day_of_week_id";
        String nameOfDay = dayOfWeek.getNameOfDay();

        long dayOfWeekId = jdbcTemplate.queryForObject(sql, new Object[] { nameOfDay }, Long.class);
        return dayOfWeekId;
    }

    public Boolean deleteDayOfWeekById(long id) {
        int rowCount = 0;
        String sql = "DELETE FROM t_day_of_week WHERE t_day_of_week = ?";

        rowCount = jdbcTemplate.update(sql, id);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public Boolean assignLessonOnTimeForDayOfWeek(long dayOfWeekId, long lessonOnTimeTableId) {
        String sql = "INSERT INTO t_day_of_week_lesson_on_table_relation(day_of_week_id, lesson_on_time_table_id) VALUES(?, ?)";
        jdbcTemplate.update(sql, dayOfWeekId, lessonOnTimeTableId);
        return true;
    }

    public Boolean removeLessonOnTimeForDayOfWeek(long dayOfWeekId, long lessonOnTimeTableId) {
        int rowCount = 0;
        String sql = "DELETE FROM t_day_of_week_lesson_on_table_relation WHERE day_of_week_id = ? , lesson_on_time_table_id = ?";

        rowCount = jdbcTemplate.update(sql, dayOfWeekId, lessonOnTimeTableId);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public Boolean insertDayOfWeek(long dayOfWeekId, long groupId) {
        String sql = "INSERT INTO t_time_table(day_of_week_id, group_id) VALUES (?,?)";
        jdbcTemplate.update(sql, dayOfWeekId, groupId);
        return true;
    }
}
