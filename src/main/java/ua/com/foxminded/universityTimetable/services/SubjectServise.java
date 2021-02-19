package ua.com.foxminded.universityTimetable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.universityTimetable.dao.SubjectDao;

@Service
public class SubjectServise {

    @Autowired
    private SubjectDao subjectDao;

}
