package ua.com.foxminded.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.foxminded.services.ClassroomService;
import ua.com.foxminded.services.TimeIntervalsService;

@Controller
@RequestMapping("/student_timetable")


public class StudentTimetableController {
    @Autowired
    ClassroomService classroomService;
    @Autowired
    TimeIntervalsService timeIntervalService;
    
    @GetMapping("/test")
    public void test() {
        //classroomService.deleteClassroom();
        timeIntervalService.setTimeInterval();
        timeIntervalService.getTimeInterval();
    }
}
