package ua.com.foxminded.universityTimetable.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import ua.com.foxminded.universityTimetable.config.SpringConfig;
import ua.com.foxminded.universityTimetable.models.Classroom;
import ua.com.foxminded.universityTimetable.rowmapper.ClassroomRowMapper;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ClassroomDaoTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    ClassroomDao classroomDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void add_ShoudReturnOne_WhenInputClassroomObjectWithRoomnumberOne() {
        long expected = 1;

        Mockito.when(
                jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(Object[].class), Mockito.eq(Long.class)))
                .thenReturn(1L);

        long actual = classroomDao.add(new Classroom(1));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getById_ShoudReturnListClassrooms_WhenInputId() {
        List<Classroom> expected = new ArrayList<Classroom>(Arrays.asList(new Classroom(1), new Classroom(2)));

        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Object[].class),
                Mockito.any(ClassroomRowMapper.class))).thenReturn(expected);

        List<Classroom> actual = classroomDao.getById(1);
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void delete_ShoudReturnTrue_WhenInputIsNumber() {
        boolean expected = true;
        
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt())).thenReturn(1);
        
        boolean actual = classroomDao.delete(1);
        Assert.assertEquals(expected, actual);
        
    }
}
