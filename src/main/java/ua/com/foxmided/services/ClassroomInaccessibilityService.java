package ua.com.foxmided.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.ClassroomInaccessibilityDao;

@Service
public class ClassroomInaccessibilityService {

    @Autowired
    private ClassroomInaccessibilityDao classroomInaccessibilityDao;

}
