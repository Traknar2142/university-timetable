package ua.com.foxminded.universityTimetable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.universityTimetable.dao.TimeIntervalDao;


@Service
public class TimeIntervalsService {
    
    @Autowired
    TimeIntervalDao timeIntervalDao;

}
