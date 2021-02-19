package ua.com.foxminded.universityTimetable.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.universityTimetable.models.Classroom;
import ua.com.foxminded.universityTimetable.rowmapper.ClassroomRowMapper;

@Repository
public class ClassroomDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClassroomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long add(Classroom classroom) {
        String sql = "INSERT INTO t_classrooms(room_number) VALUES(?) RETURNING classroom_id";
        int roomNumber = classroom.getRoomNumber();
        long classroomId = jdbcTemplate.queryForObject(sql, new Object[] { roomNumber }, Long.class);
        return classroomId;
    }

    public List<Classroom> getById(long id) {
        String sql = "SELECT* FROM t_classrooms WHERE classroom_id = ?";

        List<Classroom> classrooms = jdbcTemplate.query(sql, new Object[] { id }, new ClassroomRowMapper());
        return classrooms;
    }

    public Boolean delete(int id) {
        int rowCount = 0;
        String sql = "DELETE FROM t_classrooms WHERE  classroom_id = ?";
        rowCount = jdbcTemplate.update(sql, id);
        if (rowCount != 0) {
            return true;
        } else
            return false;
    }
}
