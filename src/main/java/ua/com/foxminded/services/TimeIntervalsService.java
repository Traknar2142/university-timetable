package ua.com.foxminded.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.TimeIntervalDao;
import ua.com.foxminded.models.TimeInterval;

@Service
public class TimeIntervalsService {
    
    @Autowired
    TimeIntervalDao timeIntervalDao;
    
    public void setTimeInterval() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss");
        LocalDateTime begin = LocalDateTime.parse("2020 12 03 12 12 12", formatter);
        LocalDateTime end = LocalDateTime.parse("2020 12 03 12 12 12", formatter);
        timeIntervalDao.insertTimeInterval(new TimeInterval(begin, end));
        
    }
    
    public void getTimeInterval() {
        timeIntervalDao.getTimeIntervalsById(1);
        List<TimeInterval> interval = timeIntervalDao.getTimeIntervalsById(1);
        for (TimeInterval timeInterval : interval) {
            System.out.println(timeInterval.getId());
            System.out.println(timeInterval.getBegin());
            System.out.println(timeInterval.getEnd());
        }
        System.out.println(timeIntervalDao.getTimeIntervalsById(1));
    }
}
