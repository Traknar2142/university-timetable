package ua.com.foxminded.universityTimetable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.universityTimetable.dao.GroupDao;

@Service
public class GroupService {

    @Autowired
    private GroupDao groupDao;

}
