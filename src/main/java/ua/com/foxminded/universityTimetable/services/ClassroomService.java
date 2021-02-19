package ua.com.foxminded.universityTimetable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.universityTimetable.dao.ClassroomDao;
import ua.com.foxminded.universityTimetable.models.Classroom;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomDao classroomDao;
    
    public void testDelete() {
        System.out.println(classroomDao.delete(5));
    }
    
    public void testAdd() {
        System.out.println(classroomDao.add(new Classroom(1)));
    }

}
