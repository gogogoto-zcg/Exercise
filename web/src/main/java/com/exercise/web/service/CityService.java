package com.exercise.web.service;

import com.exercise.web.entity.City;

import java.util.List;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/9 0009 -20:36
 * @Description : TODO
 */
public interface CityService {

    void addCity(City city);

    int deleteById(Integer id);

    int updateCity(City city);

    City getCityById(Integer id);

    List<City> findCity();

    /**
     * 根据城市名称模糊查询
     * @param name
     * @return
     */
    List<City> getCityByName(String name);
}
