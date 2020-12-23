package com.remo.filemonitoring.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1398763478438282711L;
    
    private Long id;

    private String name;

    private String address;

    private String zip;
}
