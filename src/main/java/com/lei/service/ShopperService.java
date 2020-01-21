package com.lei.service;


import com.lei.entity.Shopper;
import com.lei.util.MyShopper;

public interface ShopperService {

    public Integer addShopper(Shopper shopper);

    public MyShopper getMyShopper(String cid);

    public Integer UpdataShopperToSub(Shopper shopper);

    public Integer UpdataShopperToAdd(Shopper shopper);

    public Integer delShopper(Shopper shopper);

    public Integer delAll(String cid);

}
