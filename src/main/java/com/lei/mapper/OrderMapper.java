package com.lei.mapper;

import com.lei.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    @Insert("insert into `order`(cid,total,price) values(#{cid},#{total},#{price})")
    public Integer addOrder(Order order);
}
