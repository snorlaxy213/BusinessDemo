package com.remo.filemonitoring.mapper;
 
import com.remo.filemonitoring.model.City;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
 
@Mapper
public interface CityMapper {
 
	@Select("select * from city where state = #{state}")
	City findByState(@Param("state") String state);
	
	City selectCityById(int city_id);
 
}
