package com.example.demo.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.MyInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		@SuppressWarnings("unused")
		InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MyInterceptor());
//		interceptorRegistration.addPathPatterns("/**"); // <------ 默认拦截所有路径，这里不写也可以
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	/**
	 * 国际化，自定义实现LocaleResolver
	 * 
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		return new LocaleResolver() {
			@Override
			public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
			}

			@Override
			public Locale resolveLocale(HttpServletRequest request) {
				String lang = request.getParameter("lang"); // zh_CN en_US ja_JP
				lang = "zh_CN";
				Locale locale = request.getLocale();
				if (StringUtils.hasLength(lang)) {
					String[] localeArray = lang.split("_");
					locale = new Locale(localeArray[0], localeArray[1]);
				}
				return locale;
			}
		};
	}

}
