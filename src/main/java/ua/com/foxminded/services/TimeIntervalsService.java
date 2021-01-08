package ua.com.foxminded.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.TimeIntervalDao;


@Service
public class TimeIntervalsService {
    
    @Autowired
    TimeIntervalDao timeIntervalDao;

}
