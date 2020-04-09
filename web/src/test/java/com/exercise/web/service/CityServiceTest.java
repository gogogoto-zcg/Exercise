package com.exercise.web.service;

import com.exercise.web.WebApplication;
import com.exercise.web.entity.City;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/9 0009 -20:41
 * @Description : TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class})
class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    void addCity() {
        City city = new City();
        city.setName("杭州");
        city.setProvince("浙江");
        cityService.addCity(city);
    }

    @Test
    void deleteById() {
        cityService.deleteById(1);
    }

    @Test
    void updateCity() {
        cityService.updateCity(new City(1L,"温州","浙江"));
    }

    @Test
    void getCityById() {
        City city = cityService.getCityById(1);
        System.out.println(city);
    }

    @Test
    void findCity() {
        List<City> city = cityService.findCity();
        System.out.println(city);
    }

    @Test
    void getCityByName(){
        List<City> cityList = cityService.getCityByName("州");
        System.out.println(cityList);
    }
}