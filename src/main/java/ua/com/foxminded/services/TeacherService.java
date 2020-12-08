package ua.com.foxminded.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.TeacherDao;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

}
