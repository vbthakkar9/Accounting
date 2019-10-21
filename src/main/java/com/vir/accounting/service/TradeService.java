package com.vir.accounting.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vir.accounting.dto.TradeDto;

public interface TradeService {
	 void saveFileDetails(MultipartFile file) throws Exception;
	 List<TradeDto> getAllTrades();
}
