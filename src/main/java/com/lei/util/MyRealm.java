package com.lei.util;

import com.lei.entity.Customer;
import com.lei.service.impl.CustomerServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    public CustomerServiceImpl customerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = (String)authenticationToken.getPrincipal();

        Object credentials = authenticationToken.getCredentials();
        String psw = new String((char[]) credentials);

        Customer customer = new Customer();
        customer.setName(name);
        customer.setPsw(psw);


        Customer newCustomer = customerService.login(customer);

        if(newCustomer == null){
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, psw, "");

        return simpleAuthenticationInfo;


    }
}
