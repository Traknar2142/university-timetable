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

    public Long add(Group group) {
        String sql = "INSERT INTO t_groups(group_name) VALUES (?) RETURNING group_id";
        String groupName = group.getGroupName();

        long groupId = jdbcTemplate.queryForObject(sql, new Object[] { groupName }, Long.class);
        return groupId;
    }

    public void deleteById(long id) {
        String sql = "DELETE FROM t_groups WHERE group_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Group> getById(long id) {
        String sql = "SELECT* FROM t_groups WHERE group_id = ?";
        return jdbcTemplate.query(sql, new Object[] { id }, new GroupRowMapper());
    }
}
