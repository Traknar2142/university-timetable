package ua.com.foxminded.universityTimetable.models;

import java.util.Set;

public class Group {
    private long id;
    private String groupName;
    private Set<Subject> studiedSubjects;

    public Group(String name) {
        this.groupName = name;
    }

    public Group() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
