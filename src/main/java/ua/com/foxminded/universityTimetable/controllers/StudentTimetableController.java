package ua.com.foxminded.universityTimetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.foxminded.universityTimetable.services.ClassroomInaccessibilityService;
import ua.com.foxminded.universityTimetable.services.ClassroomService;

@Controller
@RequestMapping("/student_timetable")
public class StudentTimetableController {
    @Autowired
    ClassroomService classroomService;
    @Autowired
    ClassroomInaccessibilityService classroomInaccessibilityService;
    
    @GetMapping("/testAdd")
    public void test1() {
        classroomService.testAdd();
    }
    
    @GetMapping("/testDelete")
    public void test2() {
        classroomService.testDelete();
    }
    
    @GetMapping("/testSetClassroomInaccessibility")
    public void test3() {
        classroomInaccessibilityService.setClassroomInaccessibility();
    }
}
