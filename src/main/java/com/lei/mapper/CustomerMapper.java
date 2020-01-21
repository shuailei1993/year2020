package com.lei.mapper;

import com.lei.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    @Select("select count(1) from customer where name=#{username}")
    public Integer findUsername(String username);

    @Select("select count(1) from customer where phone=#{phone}")
    public Integer findPhone(String phone);

    @Select("select count(1) from customer where email=#{email}")
    public Integer findEmail(String email);

    @Insert("insert into customer(name,psw,phone,email,address)" +
            " values(#{name},#{psw},#{phone},#{email},#{address})")
    public Integer addCustomer(Customer customer);

    @Select("select * from customer where name=#{name} and psw=#{psw}")
    public Customer findCustomerByLogin(Customer customer);


}
