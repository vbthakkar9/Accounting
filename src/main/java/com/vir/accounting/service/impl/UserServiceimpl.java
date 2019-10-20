package com.vir.accounting.service.impl;

import com.vir.accounting.converter.UserConverter;
import com.vir.accounting.dto.UserDto;
import com.vir.accounting.entity.User;
import com.vir.accounting.repository.UserRepository;
import com.vir.accounting.service.UserService;

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
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Admin
 *
 */
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;

	private static String UPLOADED_FOLDER = "C://temp//";

	@Override
	public UserDto getUserById(Integer userId) {
		return UserConverter.entityToDto(userRepository.getOne(userId));
	}

	@Override
	public void saveUser(UserDto userDto) {
		userRepository.save(UserConverter.dtoToEntity(userDto));
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
	}
	
	@Override
	public void saveFileDetails(MultipartFile multiPartFile) throws Exception {
		// TODO Auto-generated method stub
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
        List<User> userList = new ArrayList<>();
        while (rowIterator.hasNext()) 
        {
        	UserDto user = new UserDto();
        	Row row = rowIterator.next();
        	if(row.getRowNum()==0){
        		continue;
        	}else{
        		user.setClientCode(row.getCell(0).getStringCellValue());
        		user.setClientName(row.getCell(1).getStringCellValue());
        		user.setBseCode(row.getCell(2).getStringCellValue());
        		user.setNseCode(row.getCell(3).getStringCellValue());
        		user.setFnoCode(row.getCell(4).getStringCellValue());
        		//new UserServiceimpl().saveUser(user);
        		//userRepository.save(UserConverter.dtoToEntity(user));
        		userList.add(UserConverter.dtoToEntity(user));
        	}	
        }
        userRepository.saveAll(userList);
		

	}
}
