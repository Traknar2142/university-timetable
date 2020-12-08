package ua.com.foxminded.models;

import java.util.Set;

public class Group {
    private String groupName;
    Set <Subject> studiedSubjects;
    
    public Group(String name) {
        this.groupName = name;
    }

    public Set<Subject> getStudiedSubjects() {
        return studiedSubjects;
    }

    public void setStudiedSubjects(Set<Subject> studiedSubjects) {
        this.studiedSubjects = studiedSubjects;
    }

    public String getGroupName() {
        return groupName;
    }
}
