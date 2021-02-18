package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * @PropertySource注解提供了方便地读取properties文件的功能，使用时通过Environment对象的environment.getProperty()方法直接获取就可以了
 * environment.getProperty("mail")
 */
@Configuration
@PropertySource(value = "classpath:constant.properties") // <------ 引入properties文件
public class PropertiesConfig {

}
