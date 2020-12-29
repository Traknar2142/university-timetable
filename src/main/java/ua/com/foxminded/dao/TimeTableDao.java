package ua.com.foxminded.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TimeTableDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertDayOfWeek(int dayOfWeekId, int groupId) {
        String sql = "INSERT INTO t_time_table(day_of_week_id, group_id) VALUES (?,?)";
        jdbcTemplate.update(sql, dayOfWeekId, groupId);
    }
}
