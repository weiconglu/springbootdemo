package com.example.demo.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	/**
	 * 将文件保存到指定的文件中。<br>
	 * 本方法只保证实现，不保证文件的逻辑（如，原文件名重复等）
	 * 
	 * @param file
	 * @param savedTo
	 * @throws IOException
	 */
	public static void saveFile(MultipartFile file, String savedTo) throws IOException {

		try (InputStream in = file.getInputStream(); OutputStream out = new FileOutputStream(new File(savedTo));) {

			byte[] data = new byte[1024];
			int length = 0;
			while ((length = in.read(data)) != -1) {
				out.write(data, 0, length);
			}
		}

	}

}
