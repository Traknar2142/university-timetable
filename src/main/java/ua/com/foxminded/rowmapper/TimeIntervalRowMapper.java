package ua.com.foxminded.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.com.foxminded.models.TimeInterval;

public class TimeIntervalRowMapper implements RowMapper<TimeInterval> {

    @Override
    public TimeInterval mapRow(ResultSet rs, int rowNum) throws SQLException {
        TimeInterval timeInterval = new TimeInterval();

        timeInterval.setId(rs.getLong(1));
        timeInterval.setBegin(rs.getTimestamp(2).toLocalDateTime());
        timeInterval.setEnd(rs.getTimestamp(3).toLocalDateTime());
        return timeInterval;
    }
}
