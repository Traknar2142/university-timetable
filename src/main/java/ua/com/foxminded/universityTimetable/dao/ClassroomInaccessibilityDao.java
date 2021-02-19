package ua.com.foxminded.universityTimetable.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.universityTimetable.rowmapper.IntervalIdRowMapper;

@Repository
public class ClassroomInaccessibilityDao {

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public ClassroomInaccessibilityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean add(long classroomId, long timeIntervalId) {
        String sql = "INSERT into t_classroom_inaccessibility(classroom_id, time_interval_id) VALUES(?,?)";

        int rowCount = jdbcTemplate.update(sql, classroomId, timeIntervalId);
        
        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public List<Long> getTimeIntervalsId(long classroomId) {
        List<Long> intervalsId = new ArrayList<>();
        String sql = "SELECT time_interval_id FROM t_classroom_inaccessibility WHERE classroom_id = ?";
        intervalsId = jdbcTemplate.query(sql, new Object[] { classroomId }, new IntervalIdRowMapper());

        return intervalsId;
    }

    public Boolean updateTimeIntervalId(long classroomId, long oldTimeIntervalId, long newTimeIntervalId) {
        String sql = "UPDATE t_classroom_inaccessibility SET time_interval_id = ? WHERE classroom_id = ? AND time_interval_id = ?";
        int rowCount = jdbcTemplate.update(sql, newTimeIntervalId, classroomId, oldTimeIntervalId);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public Boolean delete(long classroomId, long timeIntervalId) {
        String sql = "DELETE FROM t_classroom_inaccessibility WHERE  classroom_id = ? AND time_interval_id = ?";
        int rowCount = jdbcTemplate.update(sql, classroomId, timeIntervalId);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

}
