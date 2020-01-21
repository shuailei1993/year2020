package com.lei.service.impl;

import com.lei.entity.Customer;
import com.lei.mapper.CustomerMapper;
import com.lei.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerMapper customerMapper;

    @Override
    public Integer findUsername(String username) {
        return customerMapper.findUsername(username);
    }

    @Override
    public Integer findPhone(String phone) {
        return customerMapper.findPhone(phone);
    }

    @Override
    public Integer findEmail(String email) {
        return customerMapper.findEmail(email);
    }

    @Override
    public Integer register(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    @Override
    public Customer login(Customer customer) {
        return customerMapper.findCustomerByLogin(customer);
    }
}
