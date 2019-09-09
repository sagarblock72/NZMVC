package com.nt.controller;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.nt.command.UploadCommand;

@Controller
public class UploadController {
	
	@GetMapping("/upload.htm")
	public String showForm(@ModelAttribute("upCmd") UploadCommand cmd) {
		return "load_docu";
	}

	@PostMapping("/upload.htm")
	public String process(Map<String,Object> map,@ModelAttribute("upCmd") UploadCommand cmd)throws Exception {
		//get uploaded file
		MultipartFile resume=cmd.getResume();
		MultipartFile photo=cmd.getPhoto();
		String fileName1=null,fileName2=null;
		InputStream is=null,is1=null;
		OutputStream os=null,os1=null;
		File dir=new File("E:/SpringUploads/");
		fileName1=resume.getOriginalFilename();
		fileName2=photo.getOriginalFilename();
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		is=resume.getInputStream();
		is1=photo.getInputStream();
		
		IOUtils.copy(is, os);
		IOUtils.copy(is1, os1);
		map.put("file1", fileName1);
		map.put("file2", fileName2);
		return "result";
		
	}
}
