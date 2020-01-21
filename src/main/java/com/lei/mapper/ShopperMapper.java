package com.lei.mapper;

import com.lei.entity.Shopper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopperMapper {

    @Select("select * from shopper where cid=#{cid} and bid=#{bid}")
    public Shopper getShopperByCidAndBid(Shopper shopper);

    @Insert("insert into shopper(cid,bid,booknum) values(#{cid},#{bid},1)")
    public Integer addShopper(Shopper shopper);

    @Update("update shopper set booknum=booknum+1 where cid=#{cid} and bid=#{bid}")
    public Integer UpdataShopperToAdd(Shopper shopper);

    @Update("update shopper set booknum=booknum-1 where cid=#{cid} and bid=#{bid}")
    public Integer UpdataShopperToSub(Shopper shopper);

    @Delete("delete from shopper where cid=#{cid} and bid=#{bid}")
    public Integer delShopper(Shopper shopper);

    @Select("select * from shopper where cid=#{cid}")
    public List<Shopper> getShopperByCid(String cid);

    @Delete("delete from shopper where cid=#{cid}")
    public Integer delAll(String cid);
}
