package ua.com.foxminded.models;

public class Classroom {
    int roomNumber;
    ClassroomInaccessibility inaccessibility;
    
    public Classroom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public ClassroomInaccessibility getInaccessibility() {
        return inaccessibility;
    }

    public void setInaccessibility(ClassroomInaccessibility inaccessibility) {
        this.inaccessibility = inaccessibility;
    }
    
    public boolean isClassroomInaccessible(TimeInterval pairTime) {
        return inaccessibility.isTimeCrossing(pairTime);
    }
}
