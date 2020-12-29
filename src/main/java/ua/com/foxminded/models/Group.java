package ua.com.foxminded.models;

import java.util.Set;

public class Group {
    private int id;
    private String groupName;
    private Set<Subject> studiedSubjects;

    public Group(String name) {
        this.groupName = name;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
