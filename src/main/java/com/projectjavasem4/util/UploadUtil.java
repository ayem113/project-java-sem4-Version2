package com.projectjavasem4.util;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {

	
	@SuppressWarnings("unused")
	public  String upload(HttpSession session, MultipartFile myFile) {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("/images");
		String fileName=null;
		try {
			MultipartFile multipartFile = myFile;
			fileName = multipartFile.getOriginalFilename();
			File file = new File(path, fileName);
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			return "lỗi upload file";
		}
		return fileName;
	}
	
}
