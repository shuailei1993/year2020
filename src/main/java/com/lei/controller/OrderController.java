package com.lei.controller;

import com.lei.entity.Order;
import com.lei.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    public OrderServiceImpl orderService;

    @RequestMapping("/addOrder")
    @ResponseBody
    public String addOrder(Order order){
        Integer result = orderService.addOrder(order);
        if(result == 1){
            return "success";
        }
        return "error";
    }
}
