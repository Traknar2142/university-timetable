package ua.com.foxminded.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.Classroom;
import ua.com.foxminded.rowmapper.ClassroomRowMapper;

@Repository
public class ClassroomDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClassroomInaccessibilityDao inaccessibilityDao;

    public void insertClassroom(Classroom classroom) {
        jdbcTemplate.update("INSERT INTO t_classrooms(room_number) VALUES(?)", classroom.getRoomNumber());
    }

    public List<Classroom> getClassroomById(int id) {
        String sql = "SELECT* FROM t_classrooms WHERE classroom_id = '" + id + "'";

        List<Classroom> classrooms = jdbcTemplate.query(sql, new ClassroomRowMapper());
        for (Classroom classroom : classrooms) {
            classroom.setInaccessibility(inaccessibilityDao.getClassroomInaccessibility(id));
        }

        return classrooms;
    }

    public void deleteClassroom(int id) {
        jdbcTemplate.update("DELETE FROM t_classrooms WHERE  classroom_id = ?", id);
    }
}
