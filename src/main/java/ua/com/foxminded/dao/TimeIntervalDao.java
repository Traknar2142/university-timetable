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

    public Long add(TimeInterval timeInterval) {
        String sql = "INSERT INTO t_time_intervals(begin_time, end_time) VALUES(?,?) RETURNING time_interval_id";
        LocalDateTime begin = timeInterval.getBegin();
        LocalDateTime end = timeInterval.getEnd();

        long timeIntervalId = jdbcTemplate.queryForObject(sql, new Object[] { begin, end }, Long.class);
        return timeIntervalId;
    }

    public List<TimeInterval> getById(long id) {
        String sql = "SELECT* FROM t_time_intervals WHERE time_interval_id = ?";
        return jdbcTemplate.query(sql, new Object[] { id }, new TimeIntervalRowMapper());
    }

    public void updateById(long id, LocalDateTime begin, LocalDateTime end) {
        String sql = "UPDATE time_intervals SET begin_time = ?, end_time = ? WHERE time_interval_id = ?";
        jdbcTemplate.update(sql, begin, end, id);
    }

    public void deleteById(long id) {
        String sql = "DELETE FROM time_intervals WHERE time_interval_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
