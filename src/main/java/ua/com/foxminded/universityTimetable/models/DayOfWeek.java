package ua.com.foxminded.universityTimetable.models;

import java.util.List;

public class DayOfWeek {
    private long id;
    private String nameOfDay;
    private List<LessonOnTimeTable> lessons;

    public DayOfWeek(String nameOfDay, List<LessonOnTimeTable> lessons) {
        this.nameOfDay = nameOfDay;
        this.lessons = lessons;
    }

    public DayOfWeek() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfDay() {
        return nameOfDay;
    }

    public void setNameOfDay(String nameOfDay) {
        this.nameOfDay = nameOfDay;
    }

    public List<LessonOnTimeTable> getLessons() {
        return lessons;
    }
}
