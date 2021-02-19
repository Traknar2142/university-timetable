package ua.com.foxminded.universityTimetable.models;

public class LessonOnTimeTable {

    private Subject pair;
    private Classroom classroom;
    private Teacher teacher;
    private TimeInterval pairTime;

    public LessonOnTimeTable(Subject subject, Classroom classroom) {
        this.pair = subject;
        this.classroom = classroom;
    }

    public LessonOnTimeTable() {

    }

    public Subject getPair() {
        return pair;
    }

    public void setPair(Subject pair) {
        this.pair = pair;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Subject pair) {
        this.teacher = pair.getTeachers().iterator().next();
    }

    public TimeInterval getPairTime() {
        return pairTime;
    }

    public void setPairTime(TimeInterval pairTime) {
        if (!this.classroom.isClassroomInaccessible(pairTime)) {
            this.pairTime = pairTime;
            setInaccessibileTime(pairTime);
        }
    }

    private void setInaccessibileTime(TimeInterval pairTime) {
        this.classroom.getInaccessibility().setInaccessibileTimeIntervals(pairTime);
    }
}
