package com.lei.config;

import com.lei.util.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/*shiro配置类*/
@Configuration
public class ShiroConfig {

    @Bean
    public Realm createRealm(){
        return new MyRealm();
    }

    @Bean
    public SecurityManager createManager(){

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

       securityManager.setRealm(createRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean createFilter(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(createManager());

        //未认证跳转
        shiroFilterFactoryBean.setLoginUrl("/index");

        Map<String,String> map = new LinkedHashMap();

        map.put("/js/**", "anon");
        map.put("/css/**", "anon");
        map.put("/images/**", "anon");
        map.put("/fonts/**", "anon");

        map.put("/customer/findUsername","anon");
        map.put("/customer/findPhone","anon");
        map.put("/customer/findEmail","anon");
        map.put("/customer/register","anon");
        map.put("/customer/login","anon");

        map.put("/customer/logout","logout");


        map.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }


}
