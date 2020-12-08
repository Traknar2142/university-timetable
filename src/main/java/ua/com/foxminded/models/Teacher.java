package ua.com.foxminded.models;

import java.util.ArrayList;
import java.util.Set;

public class Teacher {
    private String firstName;
    private String lastName;
    private Set<Subject> taughtSubjects;
    
    public Teacher(String firstString, String lastName) {
        this.firstName = firstString;
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
