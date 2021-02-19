package ua.com.foxminded.universityTimetable.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.universityTimetable.models.Group;
import ua.com.foxminded.universityTimetable.models.Subject;
import ua.com.foxminded.universityTimetable.models.Teacher;
import ua.com.foxminded.universityTimetable.rowmapper.GroupIdRowMapper;
import ua.com.foxminded.universityTimetable.rowmapper.SubjectRowMapper;
import ua.com.foxminded.universityTimetable.rowmapper.TeacherIdRowMapper;

@Repository
public class SubjectDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public long add(Subject subject) {
        String sql = "INSERT INTO t_subject(sibject_name) VALUES (?) RETURNING subject_id";
        String subjectName = subject.getSubjectName();

        long subjectId = jdbcTemplate.queryForObject(sql, new Object[] { subjectName }, Long.class);
        return subjectId;
    }

    public Boolean deleteById(long id) {
        int rowCount = 0;
        String sql = "DELETE FROM t_subject WHERE subject_id = ?";
        rowCount = jdbcTemplate.update(sql, id);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public List<Subject> getById(long id) {
        String sql = "SELECT* FROM t_subject WHERE subject_id = ?";
        return jdbcTemplate.query(sql, new Object[] { id }, new SubjectRowMapper());
    }

    public Boolean assignTeacherForSubject(long teacherId, long subjectId) {
        String sql = "INSERT INTO t_subject_teacher_relation(subject_id, teacher_id) VALUES(?, ?)";
        jdbcTemplate.update(sql, subjectId, teacherId);
        return true;
    }

    public Boolean removeTeacherFromSubject(long teacherId, long subjectId) {
        int rowCount = 0;
        String sql = "DELETE FROM t_subject_teacher_relation WHERE subject_id = ? , teacher_id = ?";
        rowCount = jdbcTemplate.update(sql, subjectId, teacherId);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public Boolean assignGroupForSubject(long groupId, long subjectId) {
        String sql = "INSERT INTO t_subject_groups_relation(subject_id, group_id) VALUES(?, ?)";
        jdbcTemplate.update(sql, subjectId, groupId);
        return true;
    }

    public Boolean removeGroupFromSubject(long groupId, long subjectId) {
        int rowCount = 0;
        String sql = "DELETE FROM t_subject_groups_relation WHERE subject_id = ? , group_id = ?";
        rowCount = jdbcTemplate.update(sql, subjectId, groupId);

        if (rowCount != 0) {
            return true;
        } else
            return false;
    }

    public List<Long> getTeachersIdRelatesSubject(long subjectId) {
        List<Long> teachersId = new ArrayList<>();
        String sql = "SELECT teachers_id FROM t_subject_teacher_relation WHERE subject_id = ?";

        teachersId = jdbcTemplate.query(sql, new Object[] { subjectId }, new TeacherIdRowMapper());

        return teachersId;
    }

    public List<Long> getGroupIdRelatesSuject(long subjectId) {
        List<Long> groupsId = new ArrayList<>();
        String sql = "SELECT group_id FROM t_subject_groups_relation WHERE subject_id = ?";

        groupsId = jdbcTemplate.query(sql, new Object[] { subjectId }, new GroupIdRowMapper());

        return groupsId;
    }
}
