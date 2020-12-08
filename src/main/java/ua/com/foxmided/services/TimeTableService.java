package ua.com.foxmided.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.TimeTableDao;

@Service
public class TimeTableService {

    @Autowired
    private TimeTableDao timeTableDao;

}
