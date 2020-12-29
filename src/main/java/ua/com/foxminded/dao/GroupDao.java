package ua.com.foxminded.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.models.Group;
import ua.com.foxminded.rowmapper.GroupRowMapper;

@Repository
public class GroupDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertGroup(Group group) {
        String sql = "INSERT INTO t_groups(group_name) VALUES (?)";
        jdbcTemplate.update(sql, group.getGroupName());
    }

    public void deleteGroupById(int id) {
        String sql = "DELETE FROM t_groups WHERE group_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Group> getGroupById(int id) {
        String sql = "SELECT* FROM t_groups WHERE group_id = '" + id + "'";
        return jdbcTemplate.query(sql, new GroupRowMapper());
    }
}
