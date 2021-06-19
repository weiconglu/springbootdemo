package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.JsonResult;
import com.example.demo.model.OrderData;

import io.swagger.annotations.ApiParam;

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

	/*
	 * @RequestParam 和 @PathVariable
	 * 注解是用于从request中接收请求的，两个都可以接收参数，关键点不同的是@RequestParam
	 * 是从request里面拿取值，而 @PathVariable 是从一个URI模板里面来填充
	 */
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

	@PostMapping("json")
	public JsonResult json(@RequestBody OrderData json) {
		System.out.println(json);
		return JsonResult.ok();
	}

}
