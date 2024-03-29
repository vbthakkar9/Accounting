package com.vir.accounting.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vir.accounting.converter.TradeConverter;
import com.vir.accounting.converter.UserConverter;
import com.vir.accounting.dto.TradeDto;
import com.vir.accounting.dto.UserDto;
import com.vir.accounting.entity.Trade;
import com.vir.accounting.repository.TradeRepository;
import com.vir.accounting.repository.UserRepository;
import com.vir.accounting.service.TradeService;

@Service
public class TradeServiceImpl implements TradeService{
	
	private static String UPLOADED_FOLDER = "C://temp//";
	
	@Autowired
	TradeRepository tradeRepository;

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveFileDetails(MultipartFile multiPartFile) throws Exception {
		byte[] bytes = multiPartFile.getBytes();
		String filePath=UPLOADED_FOLDER + multiPartFile.getOriginalFilename();
		Path path = Paths.get(filePath);
		Files.write(path, bytes);
		
		FileInputStream file = new FileInputStream(new File(filePath));
		
		//Create Workbook instance holding reference to .xlsx file
		HSSFWorkbook wb = new HSSFWorkbook(file);

        //Get first/desired sheet from the workbook
		HSSFSheet sheet = wb.getSheetAt(0);

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        List<Trade> tradeList = new ArrayList<>();
        while (rowIterator.hasNext()) 
        {
        	TradeDto tradeDto = new TradeDto();
        	Row row = rowIterator.next();
        	if(row.getRowNum()==0){
        		continue;
        	}else{
        		tradeDto.setSymbol(row.getCell(1).getStringCellValue());
        		//tradeDto.setPrice(Integer.parseInt(String.valueOf((row.getCell(3).getNumericCellValue()))));
        		tradeDto.setPrice(Integer.parseInt(new DataFormatter().formatCellValue(row.getCell(3))));
        		tradeDto.setQuantity(Integer.parseInt(new DataFormatter().formatCellValue(row.getCell(4))));
        		//tradeDto.setQuantity(Integer.parseInt(String.valueOf(row.getCell(4).getStringCellValue())));
        		tradeDto.setDate(new DataFormatter().formatCellValue(row.getCell(8)));
        		tradeDto.setClientCode(row.getCell(9).getStringCellValue());
        		tradeDto.setBuySell(row.getCell(10).getStringCellValue());
        		tradeDto.setScriptCode(row.getCell(14).getStringCellValue());
        		tradeDto.setType(row.getCell(17).getStringCellValue());
        		//new UserServiceimpl().saveUser(user);
        		//userRepository.save(UserConverter.dtoToEntity(user));
        		tradeList.add(TradeConverter.dtoToEntity(tradeDto));
        	}	
        }
        tradeRepository.saveAll(tradeList);
	}

	@Override

	public List<TradeDto> getAllTrades() {
		List<UserDto> userList = userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
		List<TradeDto> tradeList = tradeRepository.findAll().stream().map(TradeConverter::entityToDto).collect(Collectors.toList());
		for(TradeDto tradedto: tradeList){
			for(UserDto userDto: userList){
				if(tradedto.getClientCode().equalsIgnoreCase(userDto.getClientCode())){
					tradedto.setClientName(userDto.getClientName());
				}
				
			}
		}
		return tradeList;
	}
	
	public List<TradeDto> getTradesByName(String name) {
		List<UserDto> userList = userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
		List<TradeDto> tradeList = tradeRepository.findBySymbolContains(name).stream().map(TradeConverter::entityToDto).collect(Collectors.toList());
		for(TradeDto tradedto: tradeList){
			for(UserDto userDto: userList){
				if(tradedto.getClientCode().equalsIgnoreCase(userDto.getClientCode())){
					tradedto.setClientName(userDto.getClientName());
				}
				
			}
		}
		return tradeList;
	}
}
