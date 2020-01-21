package com.lei.mapper;

import com.lei.entity.BookClass;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper {

    @Select("select * from class")
    public List<BookClass> getAllClass();
}
