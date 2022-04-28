package com.ssafy.config;

import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.myapp.controller.interceptor.LoginCheckInterceptor;
import com.ssafy.myapp.listener.RootPathListener;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/dept/regist_form.do").setViewName("dept/regist");
		registry.addViewController("/user/login_form.do").setViewName("login");
		registry.addViewController("/user/profile_form.do").setViewName("modify_profile");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginCheckInterceptor()).addPathPatterns("/*/auth/**");
	}

	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> addListener() {
		ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<ServletContextListener>();
		bean.setListener(new RootPathListener());
		return bean;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/profile/**").addResourceLocations("/resources/img/profile/");
	}
}
