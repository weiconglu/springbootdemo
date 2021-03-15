package com.example.demo.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    private Environment environment;

    /*
     * SpEL (Spring Expression Language)expressions. Alternatively, values may be
     * injected using ${my.app.myProp} style property placeholders.
     */
//	@Value(value = "${mail}")
//	private String mail;

    @Autowired
    public HelloController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("hello/{name}")
    public String sayHello(@ApiParam(value = "名字", type = "String", example = "张三") @PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("testProperties")
    public String testProperties() {
//		 通过注入的Environment对象getProperty()
        System.out.println(environment.getProperty("mail"));
//		// 通过SpEL表达式获取
//		System.out.println(mail);
        return "接口调用成功";
    }

}
