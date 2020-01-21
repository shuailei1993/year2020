package com.lei.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private String id;
    private String name;
    private String psw;
    private String phone;
    private String email;
    private String address;
    private String shopperId;

}
