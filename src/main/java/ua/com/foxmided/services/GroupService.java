package ua.com.foxmided.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.GroupDao;

@Service
public class GroupService {

    @Autowired
    private GroupDao groupDao;

}
