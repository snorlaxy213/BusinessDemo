package com.remo.filemonitoring.mapper;

import com.remo.filemonitoring.model.Hotel;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotelMapper {
    
    Hotel selectHotelByName(int name);
}
