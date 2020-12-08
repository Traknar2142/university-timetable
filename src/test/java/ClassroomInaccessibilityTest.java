import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import ua.com.foxminded.models.ClassroomInaccessibility;
import ua.com.foxminded.models.TimeInterval;

public class ClassroomInaccessibilityTest {
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
    TimeInterval timeInterval = new TimeInterval(LocalDateTime.parse("2018-05-24_04:00:58",formatter), LocalDateTime.parse("2018-05-24_08:00:58", formatter));
    //TimeInterval timeInterval2 = new TimeInterval(LocalDateTime.parse("2018-05-24_11:01:58", formatter), LocalDateTime.parse("2018-05-24_12:00:58",formatter));
    ClassroomInaccessibility ci = new ClassroomInaccessibility();
    
    @Test
    public void test1() {
        ci.setInaccessibileTimeIntervals(timeInterval);
        boolean actual = ci.isTimeCrossing(new TimeInterval(LocalDateTime.parse("2018-05-24_03:00:58", formatter), LocalDateTime.parse("2018-05-24_05:00:58",formatter)));
        assertEquals(true, actual);
    }
    
    @Test
    public void test2() {
        ci.setInaccessibileTimeIntervals(timeInterval);
        boolean actual = ci.isTimeCrossing(new TimeInterval(LocalDateTime.parse("2018-05-24_06:00:58", formatter), LocalDateTime.parse("2018-05-24_09:00:58",formatter)));
        assertEquals(true, actual);
    }
    
    @Test
    public void test3() {
        ci.setInaccessibileTimeIntervals(timeInterval);
        boolean actual = ci.isTimeCrossing(new TimeInterval(LocalDateTime.parse("2018-05-24_02:00:58", formatter), LocalDateTime.parse("2018-03-24_09:00:58",formatter)));
        assertEquals(true, actual);
    }
    
    @Test
    public void test4() {
        ci.setInaccessibileTimeIntervals(timeInterval);
        boolean actual = ci.isTimeCrossing(new TimeInterval(LocalDateTime.parse("2018-05-24_09:00:58", formatter), LocalDateTime.parse("2018-03-24_10:00:58",formatter)));
        assertEquals(true, actual);
    }
}
