package ua.com.foxminded.universityTimetable.dao;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import ua.com.foxminded.universityTimetable.config.SpringConfig;
import ua.com.foxminded.universityTimetable.rowmapper.IntervalIdRowMapper;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ClassroomInaccessibilityDaoTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    ClassroomInaccessibilityDao classroomInaccessibilityDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void add_ShoudReturnTrue_WhenReturnTypeIsOne() {
        boolean expected = true;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(1);
        boolean actual = classroomInaccessibilityDao.add(1, 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void add_ShoudReturnFalse_WhenReturnTypeIsZero() {
        boolean expected = false;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(0);
        boolean actual = classroomInaccessibilityDao.add(1, 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete_ShoudReturnTrue_WhenReturnTypeIsOne() {
        boolean expected = true;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(1);
        boolean actual = classroomInaccessibilityDao.delete(1, 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete_ShoudReturnFalse_WhenReturnTypeIsZero() {
        boolean expected = false;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(0);
        boolean actual = classroomInaccessibilityDao.delete(1, 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateTimeIntervalId_ShoudReturnTrue_WhenReturnTypeIsOne() {
        boolean expected = true;
        
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong()))
                .thenReturn(1);
        
        boolean actual = classroomInaccessibilityDao.updateTimeIntervalId(1, 1, 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateTimeIntervalId_ShoudReturnFalse_WhenReturnTypeIsZero() {
        boolean expected = false;
        
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong()))
                .thenReturn(0);
        
        boolean actual = classroomInaccessibilityDao.updateTimeIntervalId(1, 1, 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTimeIntervalsId_SoudReturnLongList_WhenInputId() {
        List<Long> expected = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L));
        
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(Object[].class),
                Mockito.any(IntervalIdRowMapper.class))).thenReturn(expected);
        
        List<Long> actual = classroomInaccessibilityDao.getTimeIntervalsId(1);

        Assert.assertEquals(expected, actual);
    }

}
