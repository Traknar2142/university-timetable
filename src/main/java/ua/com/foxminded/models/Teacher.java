package ua.com.foxminded.models;

import java.util.ArrayList;
import java.util.Set;

public class Teacher {
    private long id;
    private String firstName;
    private String lastName;
    private Set<Subject> taughtSubjects;

    public Teacher(String firstString, String lastName) {
        this.firstName = firstString;
        this.lastName = lastName;
    }

    public Teacher() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Subject> getTaughtSubject() {
        return taughtSubjects;
    }

    public void setTaughtSubject(Subject taughtSubject) {
        this.taughtSubjects.add(taughtSubject);
        taughtSubject.setTeachers(this);
    }
}
