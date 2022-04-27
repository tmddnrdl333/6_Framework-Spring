package com.ssafy;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ssafy.book.model.dao", annotationClass = Mapper.class)
@SpringBootApplication
public class BookappBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookappBootApplication.class, args);
	}

}
