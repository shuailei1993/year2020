package com.lei.service;

import com.lei.entity.Customer;

public interface CustomerService {

    public Integer findUsername(String username);

    public Integer findPhone(String phone);

    public Integer findEmail(String email);

    public Integer register(Customer customer);

    public Customer login(Customer customer);
}
