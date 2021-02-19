package ua.com.foxminded.universityTimetable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.universityTimetable.dao.TimeTableDao;

@Service
public class TimeTableService {

    @Autowired
    private TimeTableDao timeTableDao;

}
