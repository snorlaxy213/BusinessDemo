package com.remo.filemonitoring.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
 
@Setter
@Getter
public class City implements Serializable {
 
	private static final long serialVersionUID = 5402856784910647777L;

	private Long id;
 
	private String name;
 
	private String state;
 
	private String country;
 
}
