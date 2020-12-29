package ua.com.foxminded.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.TimeInterval;
import ua.com.foxminded.rowmapper.TimeIntervalRowMapper;

@Repository
public class TimeIntervalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertTimeInterval(TimeInterval timeInterval) {
        String sql = "INSERT INTO t_time_intervals(begin_time, end_time) VALUES(?,?)";
        jdbcTemplate.update(sql, timeInterval.getBegin(), timeInterval.getEnd());
    }

    public List<TimeInterval> getTimeIntervalsById(int id) {
        String sql = "SELECT* FROM t_time_intervals WHERE time_interval_id = '" + id + "'";
        return jdbcTemplate.query(sql, new TimeIntervalRowMapper());
    }

    public void updateTimeIntervalById(int id, LocalDateTime begin, LocalDateTime end) {
        String sql = "UPDATE time_intervals SET begin_time = ?, end_time = ? WHERE time_interval_id = ?";
        jdbcTemplate.update(sql, begin, end, id);
    }

    public void deleteTimeIntervalById(int id) {
        String sql = "DELETE FROM time_intervals WHERE time_interval_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
