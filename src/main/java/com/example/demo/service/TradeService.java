package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface TradeService {
	 void saveFileDetails(MultipartFile file) throws Exception;
}
