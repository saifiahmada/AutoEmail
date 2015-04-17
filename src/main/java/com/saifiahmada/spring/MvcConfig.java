package com.saifiahmada.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;

@Configuration

public class MvcConfig extends WebMvcConfigurerAdapter {
	
	private int maxUploadSizeInMb = 3 * 1024 * 1024; // 3 MB
	
	@Value("${com.saifiahmada.spring.path}")
    private String path;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
		registry.addViewController("/access").setViewName("access");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/static/bootstrap/3.1.0/");
		registry.addResourceHandler("/jquery/**").addResourceLocations("classpath:/static/jquery/");
	    registry.addResourceHandler("/jqueryui/**").addResourceLocations("classpath:/static/jqueryui/");
	    registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
	    registry.addResourceHandler("/datepicker/**").addResourceLocations("classpath:/static/datepicker/");
	    registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		/*linux*/
	    //registry.addResourceHandler("/foto/**").addResourceLocations("file:///home/saifi/Desktop/foto/");
	    /*windows*/
	    registry.addResourceHandler("/tutorial_pdf/**").addResourceLocations("file://"+path);
	    
	}
	
	@Bean
	public SecurityConfig securityConfig(){
		return new SecurityConfig();
	}
	
	/*@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(maxUploadSizeInMb);
		return multipartResolver;
	}*/
	
	@Bean
	public StandardServletMultipartResolver multipartResolver(){
		StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
		return multipartResolver;
	}
	
	/*@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setFallbackPageable(new PageRequest(1, 5) ); 
		argumentResolvers.add(new ServletWebArgumentResolverAdapter((WebArgumentResolver) resolver));  
	}*/
	
	/*@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableArgumentResolver resolver = new PageableArgumentResolver();
        resolver.setFallbackPagable(new PageRequest(1, 5));
        argumentResolvers.add(new ServletWebArgumentResolverAdapter(resolver));
    }*/

}
