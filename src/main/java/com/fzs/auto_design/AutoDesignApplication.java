package com.fzs.auto_design;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class AutoDesignApplication extends WebMvcConfigurerAdapter {

	@PostConstruct
	private void afterInit() {
		System.out.println("----------it works -----------------");
		System.out.println("Application is Started With Active Profile is : [" + "application.yml" + "]");
		System.out.println("--------------------------------------------");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		// 初始化转换器
		FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
		// 初始化一个转换器配置
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 将配置设置给转换器并添加到HttpMessageConverter转换器列表中
		fastConvert.setFastJsonConfig(fastJsonConfig);
		converters.add(fastConvert);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/templates/static/**")
				.addResourceLocations("classpath:/templates/static/");
	}

	public static void main(String[] args) {
		SpringApplication.run(AutoDesignApplication.class, args);
	}
}
