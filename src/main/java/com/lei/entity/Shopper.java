package com.lei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shopper implements Serializable {

    private String cid;
    private String bid;
    private Integer booknum;
    private Book book;

}
