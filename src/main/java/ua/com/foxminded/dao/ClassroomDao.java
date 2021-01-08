package ua.com.foxminded.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.Classroom;
import ua.com.foxminded.rowmapper.ClassroomRowMapper;

@Repository
public class ClassroomDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public void delete(long id) {
        String query = "DELETE FROM t_classrooms WHERE  classroom_id = ?";

        jdbcTemplate.update(query, id);
    }
}
