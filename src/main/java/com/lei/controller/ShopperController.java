package com.lei.controller;

import com.lei.entity.Customer;
import com.lei.entity.Shopper;
import com.lei.service.impl.ShopperServiceImpl;
import com.lei.util.MyShopper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shopper")
public class ShopperController {

    @Autowired
    public ShopperServiceImpl shopperService;

    @RequestMapping("/addShopper")
    @ResponseBody
    public String addShopper(String bid, HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        String cid = customer.getId();

        Shopper shopper = new Shopper();
        shopper.setCid(cid);
        shopper.setBid(bid);

        Integer result = shopperService.addShopper(shopper);

        if(result == 1){
            return "success";
        }

        return "error";

    }


    @RequestMapping("/toShopping")
    public String toShopping(String cid, Model model){
        MyShopper myShopper = shopperService.getMyShopper(cid);
        model.addAttribute("myShopper",myShopper);

        return "/before/shopper";
    }

    @RequestMapping("/sub")
    @ResponseBody
    public String sub(String cid,String bid){

        Shopper shopper = new Shopper();
        shopper.setCid(cid);
        shopper.setBid(bid);

        shopperService.UpdataShopperToSub(shopper);

        return "success";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(String cid,String bid){
        Shopper shopper = new Shopper();
        shopper.setCid(cid);
        shopper.setBid(bid);

        shopperService.UpdataShopperToAdd(shopper);

        return "success";
    }

    @RequestMapping("/delShopper")
    @ResponseBody
    public String delShopper(String cid,String bid){
        Shopper shopper = new Shopper();
        shopper.setCid(cid);
        shopper.setBid(bid);

        shopperService.delShopper(shopper);

        return "success";
    }

    @RequestMapping("/delAll")
    @ResponseBody
    public String delAll(String cid){

        shopperService.delAll(cid);

        return "success";
    }



}
