package ua.com.foxminded.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.Group;
import ua.com.foxminded.models.Subject;
import ua.com.foxminded.models.Teacher;
import ua.com.foxminded.rowmapper.GroupIdRowMapper;
import ua.com.foxminded.rowmapper.SubjectRowMapper;
import ua.com.foxminded.rowmapper.TeacherIdRowMapper;

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

    public void deleteById(long id) {
        String sql = "DELETE FROM t_subject WHERE subject_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Subject> getById(long id) {
        String sql = "SELECT* FROM t_subject WHERE subject_id = ?";
        return jdbcTemplate.query(sql, new Object[] { id }, new SubjectRowMapper());
    }

    public void assignTeacherForSubject(long teacherId, long subjectId) {
        String sql = "INSERT INTO t_subject_teacher_relation(subject_id, teacher_id) VALUES(?, ?)";
        jdbcTemplate.update(sql, subjectId, teacherId);
    }

    public void removeTeacherFromSubject(long teacherId, long subjectId) {
        String sql = "DELETE FROM t_subject_teacher_relation WHERE subject_id = ? , teacher_id = ?";
        jdbcTemplate.update(sql, subjectId, teacherId);
    }

    public void assignGroupForSubject(long groupId, long subjectId) {
        String sql = "INSERT INTO t_subject_groups_relation(subject_id, group_id) VALUES(?, ?)";
        jdbcTemplate.update(sql, subjectId, groupId);
    }

    public void removeGroupFromSubject(long groupId, long subjectId) {
        String sql = "DELETE FROM t_subject_groups_relation WHERE subject_id = ? , group_id = ?";
        jdbcTemplate.update(sql, subjectId, groupId);
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
