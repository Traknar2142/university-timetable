package ua.com.foxminded.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.ClassroomInaccessibility;
import ua.com.foxminded.models.TimeInterval;
import ua.com.foxminded.rowmapper.IntervalIdRowMapper;

@Repository
public class ClassroomInaccessibilityDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(long classroomId, long timeIntervalId) {
        String sql = "INSERT into t_classroom_inaccessibility(classroom_id, time_interval_id) VALUES(?,?)";
        jdbcTemplate.update(sql, classroomId, timeIntervalId);
    }

    public List<Long> getTimeIntervalsId(long classroomId) {
        List<Long> intervalsId = new ArrayList<>();
        String sql = "SELECT time_interval_id FROM t_classroom_inaccessibility WHERE classroom_id = ?";
        intervalsId = jdbcTemplate.query(sql, new Object[] { classroomId }, new IntervalIdRowMapper());

        return intervalsId;
    }

}
