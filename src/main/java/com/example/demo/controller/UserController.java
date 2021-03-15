package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@RestController
@RequestMapping("/")
public class UserController {

	private UserMapper userMapper;

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@GetMapping("insertTestData")
	public String insertTestData() {

		User user = new User();
		for (int i = 0; i < 10; i++) {
			user.setUsername("user" + (i + 1));
			user.setPassword("password" + (i + 1));
			userMapper.insert(user);
		}

		return "插入测试数据到数据库";
	}

}
