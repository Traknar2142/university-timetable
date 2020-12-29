package ua.com.foxminded.models;

import java.util.HashSet;
import java.util.Set;

public class Subject {
    private int id;
    private String subjectName;
    private Set<Teacher> teachers = new HashSet<>();
    private Set<Classroom> availableClassrooms;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
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
