package ua.com.foxminded.models;

public class LessonOnTimeTable {
    private Subject pair;
    private Classroom classroom;
    private Teacher teacher;
    private TimeInterval pairTime;
    
    public LessonOnTimeTable(Subject subject, Classroom classroom) {
        this.pair = subject;
        this.classroom = classroom;
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
        if(!this.classroom.isClassroomInaccessible(pairTime)) {
            this.pairTime = pairTime;
            setInaccessibileTime(pairTime);
        }        
    }
    
    private void setInaccessibileTime(TimeInterval pairTime) {
        this.classroom.getInaccessibility().setInaccessibileTimeIntervals(pairTime);
    }
}
