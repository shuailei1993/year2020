package com.lei.mapper;

import com.lei.entity.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    @Select("select count(1) from book")
    public Integer getAllBookCount();

    @Select("select * from book limit #{start},3")
    public List<Book> getAllBook(Integer start);

    @Select("select count(1) from book where classid=#{classid}")
    public Integer getBookCountByClassId(String classid);

    @Select("select * from book where classid=#{classid} limit #{start},3")
    public List<Book> getBookByClassId(String classid,Integer start);

    @Select("select * from book where id=#{id}")
    public Book getBookById(String id);
}
