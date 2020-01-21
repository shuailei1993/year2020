package com.lei.controller;

import com.lei.entity.Customer;
import com.lei.entity.Shopper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /*@RequestMapping("/addShopper")
    @ResponseBody
    public String addShopper(String bid, HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");


        if(redisTemplate.opsForHash().get())

        Shopper shopper = new Shopper();
        shopper.setCid(customer.getId());



    }*/


}
