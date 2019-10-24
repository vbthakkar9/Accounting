package com.vir.accounting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vir.accounting.dto.TradeDto;
import com.vir.accounting.service.TradeService;
import com.vir.accounting.utils.Constants;

@RequestMapping("/tradeFile")
@RestController
public class TradeResources {

	@Autowired
	TradeService tradeService;
	
	@PostMapping("/upload")	
	public void singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {		
		tradeService.saveFileDetails(file);
	}
	
	@RequestMapping(Constants.GET_ALL_TRADES)
	public List<TradeDto> getAllUsers() {
		return tradeService.getAllTrades();
	}

	@RequestMapping(Constants.GET_TRADES_BY_NAME)
	public List<TradeDto> getTradesByName(@RequestParam String name) {
		return tradeService.getTradesByName(name);
	}
	
}
