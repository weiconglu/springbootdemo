package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Dog;
import com.example.demo.model.Employee;
import com.example.demo.model.User;

@Controller
public class ThymeleafController {

	@GetMapping("/var_expression")
	public String varExpression(Model model) {

		// private 属性可以在bean中添加好get方法，使用时.出来或者直接使用get方法
		Employee emp = Employee.builder().id(1001).lastName("李四").age(20).email("ls@test.com").gender(1).build();

		// public 属性可以直接.出来
		User user = new User();
		user.userName = "李四";
		user.gender = "女";
		user.address = "北京";
		user.dog = new Dog();
		user.dog.dogName = "旺财";

		model.addAttribute("username", "张三");
		model.addAttribute("age", 18);

		model.addAttribute("emp", emp);

		model.addAttribute("user", user);

		return "var_expression";
	}

}
