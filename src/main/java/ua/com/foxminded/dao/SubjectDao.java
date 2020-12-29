package ua.com.foxminded.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.Group;
import ua.com.foxminded.models.Subject;
import ua.com.foxminded.models.Teacher;
import ua.com.foxminded.rowmapper.SubjectRowMapper;

@Repository
public class SubjectDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    GroupDao groupDao;

    public void insertSubject(Subject subject) {
        String sql = "INSERT INTO t_subject(sibject_name) VALUES (?)";
        jdbcTemplate.update(sql, subject.getSubjectName());
    }

    public void deleteSubjectById(int id) {
        String sql = "DELETE FROM t_subject WHERE subject_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Subject> getSubjectById(int id) {
        String sql = "SELECT* FROM t_subject WHERE subject_id = '" + id + "'";
        return jdbcTemplate.query(sql, new SubjectRowMapper());
    }

    public void assignTeacherForSubject(int teacherId, int subjectId) {
        String sql = "INSERT INTO t_subject_teacher_relation(subject_id, teacher_id) VALUES(?, ?)";
        jdbcTemplate.update(sql, subjectId, teacherId);
    }

    public void removeTeacherFromSubject(int teacherId, int subjectId) {
        String sql = "DELETE FROM t_subject_teacher_relation WHERE subject_id = ? , teacher_id = ?";
        jdbcTemplate.update(sql, subjectId, teacherId);
    }

    public void assignGroupForSubject(int groupId, int subjectId) {
        String sql = "INSERT INTO t_subject_groups_relation(subject_id, group_id) VALUES(?, ?)";
        jdbcTemplate.update(sql, subjectId, groupId);
    }

    public void removeGroupFromSubject(int groupId, int subjectId) {
        String sql = "DELETE FROM t_subject_groups_relation WHERE subject_id = ? , group_id = ?";
        jdbcTemplate.update(sql, subjectId, groupId);
    }

    private List<Integer> getTeachersIdRelatesSubject(int subjectId) {
        List<Integer> teachersId = new ArrayList<>();
        String sql = "SELECT teachers_id FROM t_subject_teacher_relation WHERE subject_id = '" + subjectId + "'";

        jdbcTemplate.query(sql, (rs, rowNum) -> {
            teachersId.add(rs.getInt(1));
            return teachersId;
        });

        return teachersId;
    }

    private List<Teacher> getTeachers(List<Integer> trachersId) {
        List<Teacher> teachers = new ArrayList<>();
        for (Integer id : trachersId) {
            teachers.addAll(teacherDao.getTeacherById(id));
        }
        return teachers;
    }

    private List<Integer> getGroupIdRelatesSuject(int subjectId) {
        List<Integer> groupsId = new ArrayList<>();
        String sql = "SELECT group_id FROM t_subject_groups_relation WHERE subject_id = '" + subjectId + "'";

        jdbcTemplate.query(sql, (rs, rowNum) -> {
            groupsId.add(rs.getInt(1));
            return groupsId;
        });

        return groupsId;
    }

    private List<Group> getGroups(List<Integer> subjectsId) {
        List<Group> groups = new ArrayList<>();
        for (Integer id : subjectsId) {
            groups.addAll(groupDao.getGroupById(id));
        }
        return groups;
    }
}
