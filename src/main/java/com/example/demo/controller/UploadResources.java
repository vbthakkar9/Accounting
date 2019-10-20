package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.UserService;

/**
 * 
 * @author Admin
 *
 */
@RequestMapping("/uploadFile")
@RestController
public class UploadResources {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/upload")
	//@GetMapping("/upload")
	public void singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {		
		//FileService fileService = new FileServiceImpl();
		userService.saveFileDetails(file);
				
	}
}
