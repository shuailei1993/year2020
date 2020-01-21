package com.lei.service.impl;

import com.lei.entity.Book;
import com.lei.mapper.BookMapper;
import com.lei.service.BookService;
import com.lei.util.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookMapper bookMapper;

    @Override
    public MyPage getBookList(String classid, String page) {
        Integer currpage = Integer.parseInt(page);
        Integer start = (currpage-1)*3;
        Integer total = 0;
        List<Book> data = new ArrayList();

        if("0".equals(classid)){
            total = bookMapper.getAllBookCount();
            data = bookMapper.getAllBook(start);
        }else{
            total = bookMapper.getBookCountByClassId(classid);
            data = bookMapper.getBookByClassId(classid,start);
        }

        Integer size = total/3;
        if(size == 0){
            size = 1;
        }

        MyPage myPage = new MyPage(data,page,size,total);

        return myPage;
    }
}
