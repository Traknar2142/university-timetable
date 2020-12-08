package ua.com.foxminded.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.dao.SubjectDao;

@Service
public class SubjectServise {

    @Autowired
    private SubjectDao subjectDao;

}
