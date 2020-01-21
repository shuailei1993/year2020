package com.lei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private String id;
    private String bookname;
    private String author;
    private Double price;
    private String classid;
    private String descr;
    private String path;

}
