package ua.com.foxminded.models;

import java.util.ArrayList;
import java.util.List;

public class ClassroomInaccessibility {
    private List<TimeInterval> timeIntervals = new ArrayList<>();

    public List<TimeInterval> getTimeIntervals() {
        return timeIntervals;
    }

    public void setInaccessibileTimeIntervals(TimeInterval timeInterval) {
        if (!isTimeCrossing(timeInterval)) {
            this.timeIntervals.add(timeInterval);
        }
    }

    public boolean isTimeCrossing(TimeInterval interval) {
        for (TimeInterval timeInterval : this.timeIntervals) {
            boolean isBeginAfterBeginTime = interval.getBegin().isAfter(timeInterval.getBegin());
            boolean isEndBeforeEndTime = interval.getEnd().isBefore(timeInterval.getEnd());
            boolean isEndAfterBeginTime = interval.getEnd().isAfter(timeInterval.getBegin());
            boolean isBeginBeforeEndTime = interval.getBegin().isBefore(timeInterval.getEnd());

            if (isEndAfterBeginTime && isEndBeforeEndTime) {
                return true;
            }

            if (isBeginAfterBeginTime && isBeginBeforeEndTime) {
                return true;
            }
        }
        return false;
    }
}
