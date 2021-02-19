package ua.com.foxminded.universityTimetable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.universityTimetable.dao.ClassroomInaccessibilityDao;

@Service
public class ClassroomInaccessibilityService {

    @Autowired
    private ClassroomInaccessibilityDao classroomInaccessibilityDao;
    
    public void setClassroomInaccessibility() {
        classroomInaccessibilityDao.add(11, 10);
    }

}
