package com.example.demo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.JsonResult;
import com.example.demo.common.utils.FileUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/file")
public class FileController {

	@ApiOperation("接收上传的文件")
	@PostMapping("upload")
	public JsonResult upload(
			@ApiParam(value = "filename", type = "MultipartFile") @RequestParam("file") MultipartFile file) {

		try {
			FileUtils.saveFile(file, file.getOriginalFilename());
			return JsonResult.ok();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return JsonResult.error();
	}

}
