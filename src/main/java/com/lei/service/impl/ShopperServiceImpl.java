package com.lei.service.impl;

import com.lei.entity.Book;
import com.lei.entity.Shopper;
import com.lei.mapper.BookMapper;
import com.lei.mapper.ShopperMapper;
import com.lei.service.ShopperService;
import com.lei.util.MyShopper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopperServiceImpl implements ShopperService {

    @Autowired
    public ShopperMapper shopperMapper;

    @Autowired
    public BookMapper bookMapper;

    @Override
    public Integer addShopper(Shopper shopper) {
        Integer result = 0;
        if(shopperMapper.getShopperByCidAndBid(shopper) == null){
            System.out.println(shopper.getBid());
            System.out.println(shopper.getCid());
            result = shopperMapper.addShopper(shopper);
        }else{
            result = shopperMapper.UpdataShopperToAdd(shopper);
        }
        return result;
    }

    @Override
    public MyShopper getMyShopper(String cid) {

        List<Shopper> data = shopperMapper.getShopperByCid(cid);
        Integer total = 0;
        Double price = 0.0;
        for (Shopper shopper : data) {
            total += shopper.getBooknum();
            Book book = bookMapper.getBookById(shopper.getBid());
            shopper.setBook(book);
            price += (book.getPrice()) * (shopper.getBooknum());
        }

        MyShopper myShopper = new MyShopper(data,total,price);

        return myShopper;
    }

    @Override
    public Integer UpdataShopperToSub(Shopper shopper) {
        shopperMapper.UpdataShopperToSub(shopper);
        Shopper newShopper = shopperMapper.getShopperByCidAndBid(shopper);
        if(newShopper.getBooknum() == 0){
            shopperMapper.delShopper(shopper);
        }
        return 1;
    }

    @Override
    public Integer UpdataShopperToAdd(Shopper shopper) {
        return shopperMapper.UpdataShopperToAdd(shopper);
    }

    @Override
    public Integer delShopper(Shopper shopper) {
        return shopperMapper.delShopper(shopper);
    }

    @Override
    public Integer delAll(String cid) {
        return shopperMapper.delAll(cid);
    }
}
