package com.exercise.web.controller;

import com.exercise.web.entity.City;
import com.exercise.web.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : cg.Zhou
 * @date : 2020/5/8 0008 12:07
 * @Description : TODO
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping
    public List<City> findCity(){
        List<City> city = cityService.findCity();
        return city;
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable("id")Integer id){
        City city = cityService.getCityById(id);
        return city;
    }

    @PutMapping("/{id}")
    public void updateCity(@PathVariable("id")Long id){
        cityService.updateCity(new City(id,"温州","浙江"));
    }

}
