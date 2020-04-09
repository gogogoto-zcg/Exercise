package com.exercise.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exercise.web.entity.City;
import com.exercise.web.mapper.CityMapper;
import com.exercise.web.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/9 0009 -20:36
 * @Description : TODO
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public void addCity(City city) {
        cityMapper.insert(city);
    }

    @Override
    public int deleteById(Integer id) {
        return cityMapper.deleteById(id);
    }

    @Override
    public int updateCity(City city) {
        return cityMapper.updateById(city);
    }

    @Override
    public City getCityById(Integer id) {
        return cityMapper.selectById(id);
    }

    @Override
    public List<City> findCity() {
        return cityMapper.selectList(null);
    }

    @Override
    public List<City> getCityByName(String name) {
        QueryWrapper<City> wrapper = new QueryWrapper<>();
        wrapper.like("name",name);
        return cityMapper.selectList(wrapper);
    }
}
