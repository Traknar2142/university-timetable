package ua.com.foxminded.models;

import java.util.LinkedHashSet;
import java.util.Set;

public class Subject {
    private String subjectName;
    private Set<Teacher> teachers = new LinkedHashSet<>();
    private Set<Classroom> availableClassrooms;
    
    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers.add(teachers);
        teachers.setTaughtSubject(this);
    }

    public Set<Classroom> getAvailableClassrooms() {
        return availableClassrooms;
    }

    public void setAvailableClassrooms(Set<Classroom> availableClassrooms) {
        this.availableClassrooms = availableClassrooms;
    }
}
