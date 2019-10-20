package com.vir.accounting.service;

import org.springframework.web.multipart.MultipartFile;

public interface TradeService {
	 void saveFileDetails(MultipartFile file) throws Exception;
}
