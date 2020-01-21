package com.lei.util;

import com.lei.entity.Shopper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyShopper {

    private List<Shopper> data;
    private Integer total;
    private Double price;
}
