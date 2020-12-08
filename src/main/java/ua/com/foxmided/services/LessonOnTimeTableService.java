package ua.com.foxmided.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.LessonOnTimeTableDao;

@Service
public class LessonOnTimeTableService {

    @Autowired
    private LessonOnTimeTableDao lessonOnTimeTableDao;

}
