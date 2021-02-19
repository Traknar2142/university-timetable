package ua.com.foxminded.universityTimetable.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.foxminded.universityTimetable.models.Group;
import ua.com.foxminded.universityTimetable.rowmapper.GroupRowMapper;

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
    
    public Boolean updateNameGroup(String newGroupName, Long id) {
        int rowCount = 0;
        String sql = "UPDATE t_groups SET group_name = ? WHERE group_id = ?";
        rowCount = jdbcTemplate.update(sql, newGroupName, id);
        
        if (rowCount != 0) {
            return true;
        } else return false;
        
    }

    public Boolean deleteById(long id) {
        int rowCount = 0;
        String sql = "DELETE FROM t_groups WHERE group_id = ?";
        rowCount = jdbcTemplate.update(sql, id);
        
        if (rowCount != 0) {
            return true;
        } else return false;
    }

    public List<Group> getById(long id) {
        String sql = "SELECT* FROM t_groups WHERE group_id = ?";
        return jdbcTemplate.query(sql, new Object[] { id }, new GroupRowMapper());
    }
}
