package com.lei.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPage {
    private List data;
    private String page;
    private Integer size;
    private Integer total;
}
