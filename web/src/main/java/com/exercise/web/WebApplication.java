package com.exercise.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.exercise.web.mapper")
@SpringBootApplication
@ServletComponentScan
//排除扫描包
@ComponentScan(excludeFilters =
		{
				@ComponentScan.Filter(type = FilterType.REGEX,pattern = "com.exercise.web.mq.*")
		})
//@EnableScheduling
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
