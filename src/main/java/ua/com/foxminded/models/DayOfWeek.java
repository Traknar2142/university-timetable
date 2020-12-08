package ua.com.foxminded.models;

import java.util.List;

public class DayOfWeek {
    
    private String nameOfDay;
    private List<LessonOnTimeTable> lessons;
    
    public DayOfWeek(String nameOfDay, List<LessonOnTimeTable> lessons) {
        this.nameOfDay = nameOfDay;
        this.lessons = lessons;
    }

    public String getNameOfDay() {
        return nameOfDay;
    }

    public List<LessonOnTimeTable> getLessons() {
        return lessons;
    }
    
    
}
