package ua.com.foxminded.models;

import java.util.List;

public class TimeTable {
    private List<DayOfWeek> days;
    private List<Group> groups;
    
    public TimeTable(List<DayOfWeek> days, List<Group> groups) {
        this.days = days;
        this.groups = groups;
    }
}
