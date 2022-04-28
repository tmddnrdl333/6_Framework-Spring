package com.ssafy;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ssafy.myapp.model.dao", annotationClass = Mapper.class)
@SpringBootApplication
public class SpringStep09MvcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStep09MvcBootApplication.class, args);
	}

}
