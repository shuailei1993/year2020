package com.lei.controller;

import com.lei.entity.BookClass;
import com.lei.entity.Customer;
import com.lei.service.impl.BookServiceImpl;
import com.lei.service.impl.ClassServiceImpl;
import com.lei.service.impl.CustomerServiceImpl;
import com.lei.util.MyPage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerServiceImpl customerService;

    @Autowired
    public ClassServiceImpl classService;

    @Autowired
    public BookServiceImpl bookService;

    @RequestMapping("/findUsername")
    @ResponseBody
    public String findByUsername(String username){
        Integer result = customerService.findUsername(username);
        if(result>0){
            return "1";
        }
        return "0";
    }

    @RequestMapping("/findPhone")
    @ResponseBody
    public String findPhone(String phone){
        Integer result = customerService.findPhone(phone);
        if(result>0){
            return "1";
        }
        return "0";
    }

    @RequestMapping("/findEmail")
    @ResponseBody
    public String findEmail(String email){
        Integer result = customerService.findEmail(email);
        if(result>0){
            return "1";
        }
        return "0";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(Customer customer){
        Integer result = customerService.register(customer);
        if(result>0){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(Customer customer, HttpSession session,Model model){

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(customer.getName(), customer.getPsw());
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
        }catch (Exception e){
            return "error";
        }

        Customer loginCustomer = customerService.login(customer);
        model.addAttribute("classid","0");
        session.setAttribute("customer",loginCustomer);
        return "success";
    }

    @RequestMapping("/toList")
    public String toList(String classid,String page,Model model){
        if(classid == null || "".equals(classid) ){
            classid = "0";
        }
        if(page == null || "".equals(page) ){
            page = "1";
        }


        MyPage myPage = bookService.getBookList(classid, page);

        List<BookClass> classes = classService.getAllClass();
        model.addAttribute("classes",classes);
        model.addAttribute("classid",classid);
        model.addAttribute("myPage",myPage);
        return "/before/list";
    }

}
