package com.nt.command;

import org.springframework.web.multipart.MultipartFile;


public class UploadCommand {
	
	private MultipartFile resume;
	private MultipartFile photo;
	
	public MultipartFile getResume() {
		return resume;
	}
	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

}
