package ua.com.foxmided.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.DayOfWeekDao;

@Service
public class DayOfWeekService {

    @Autowired
    private DayOfWeekDao dayOfWeekDao;

}
