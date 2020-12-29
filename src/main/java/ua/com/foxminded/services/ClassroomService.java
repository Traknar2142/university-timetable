package ua.com.foxminded.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.ClassroomDao;
import ua.com.foxminded.models.Classroom;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomDao classroomDao;
    
    public void setClassroom() {
        classroomDao.insertClassroom(new Classroom(12));
    }
    
    public void deleteClassroom() {
        classroomDao.deleteClassroom(1);
    }

}
