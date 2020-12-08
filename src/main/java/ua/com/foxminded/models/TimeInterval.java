package ua.com.foxminded.models;

import java.time.LocalDateTime;

public class TimeInterval {
    private LocalDateTime begin, end;
    
    public LocalDateTime getBegin() {
        return begin;
    }
    
    public LocalDateTime getEnd() {
        return end;
    }

    public TimeInterval(LocalDateTime begin, LocalDateTime end) {
        this.begin = begin;
        this.end = end;
    }
}
