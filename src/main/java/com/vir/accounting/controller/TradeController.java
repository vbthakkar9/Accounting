package com.vir.accounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TradeController {
	
	@RequestMapping("/trade")
	public String upload() {
		return "tradeupload";
	}
}
