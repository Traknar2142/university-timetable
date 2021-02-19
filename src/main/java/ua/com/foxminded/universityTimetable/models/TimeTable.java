package ua.com.foxminded.universityTimetable.models;

import java.util.List;

public class TimeTable {
    private List<DayOfWeek> days;
    private List<Group> groups;

    public TimeTable(List<DayOfWeek> days, List<Group> groups) {
        this.days = days;
        this.groups = groups;
    }
}
