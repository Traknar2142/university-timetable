package ua.com.foxminded.models;

public class Classroom {
    private int roomNumber;
    private long id;
    private ClassroomInaccessibility inaccessibility;

    public Classroom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Classroom() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
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
