package com.lei.service.impl;

import com.lei.entity.BookClass;
import com.lei.mapper.ClassMapper;
import com.lei.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<BookClass> getAllClass() {
        return classMapper.getAllClass();
    }
}
