package ua.com.foxminded.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.ClassroomInaccessibility;
import ua.com.foxminded.models.TimeInterval;

@Repository
public class ClassroomInaccessibilityDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TimeIntervalDao timeIntervalDao;

    public void addClassroomInaccessibility(int classroomId, int timeIntervalId) {
        jdbcTemplate.update("INSERT into t_classroom_inaccessibility(classroom_id, time_interval_id) VALUES(?,?)",
                classroomId, timeIntervalId);
    }

    public ClassroomInaccessibility getClassroomInaccessibility(int classroomId) {

        List<Integer> intervalsId = getTimeIntervalsId(classroomId);
        List<TimeInterval> timeIntervals = getTimeIntervals(intervalsId);

        ClassroomInaccessibility classroomInaccessibility = new ClassroomInaccessibility();

        for (TimeInterval timeInterval : timeIntervals) {
            classroomInaccessibility.setInaccessibileTimeIntervals(timeInterval);
        }

        return classroomInaccessibility;
    }

    private List<Integer> getTimeIntervalsId(int classroomId) {
        List<Integer> intervalsId = new ArrayList<>();
        String sql = "SELECT time_interval_id FROM t_classroom_inaccessibility WHERE classroom_id = '" + classroomId
                + "'";
        jdbcTemplate.query(sql, (rs, rowNum) -> {
            intervalsId.add(rs.getInt(1));
            return intervalsId;
        });
        return intervalsId;
    }

    private List<TimeInterval> getTimeIntervals(List<Integer> timeIntervalsId) {
        List<TimeInterval> timeInterval = new ArrayList<>();
        for (Integer id : timeIntervalsId) {
            timeInterval.addAll(timeIntervalDao.getTimeIntervalsById(id));
        }
        return timeInterval;
    }
}
