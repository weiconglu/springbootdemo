package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.JsonResult;

@RestController
@RequestMapping("/mail")
public class MailController {

	private JavaMailSender javaMailSender;

	@Autowired
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@GetMapping("send")
	public JsonResult send() {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject("test");
		simpleMailMessage.setText("test body");
		simpleMailMessage.setTo("lu_weicong@purvar.co.jp");

		try {
			javaMailSender.send(simpleMailMessage);
		} catch (MailException e) {
			e.printStackTrace();
			return JsonResult.error();
		}

		return JsonResult.ok();
	}

}
