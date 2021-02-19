package ua.com.foxminded.universityTimetable.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class IntervalIdRowMapper implements RowMapper<Long>{

    @Override
    public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
        long intervalId = rs.getLong(1);
        return intervalId;
    }
}
