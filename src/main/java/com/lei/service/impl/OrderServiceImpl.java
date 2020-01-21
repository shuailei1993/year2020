package com.lei.service.impl;

import com.lei.entity.Order;
import com.lei.mapper.OrderMapper;
import com.lei.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderMapper orderMapper;

    @Override
    public Integer addOrder(Order order) {
        return orderMapper.addOrder(order);
    }
}
