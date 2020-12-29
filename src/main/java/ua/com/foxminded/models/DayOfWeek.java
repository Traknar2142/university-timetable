package ua.com.foxminded.models;

import java.util.List;

public class DayOfWeek {
    private int id;
    private String nameOfDay;
    private List<LessonOnTimeTable> lessons;

    public DayOfWeek(String nameOfDay, List<LessonOnTimeTable> lessons) {
        this.nameOfDay = nameOfDay;
        this.lessons = lessons;
    }

    public DayOfWeek() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
