package com.vir.accounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "userlist";
	}
	
	@RequestMapping("/tradeList")
	public String tradeList() {
		return "tradelist";
	}
	
	@RequestMapping("/file")
	public String uploadUserFile() {
		return "fileupload";
	}
	
	@RequestMapping("/trade")
	public String uploadTradeFile() {
		return "tradeupload";
	}
}
