package com.vir.accounting.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vir.accounting.dto.UserDto;

/**
 * 
 * @author Admin
 *
 */
public interface UserService {
    UserDto getUserById(Integer userId);
    void saveUser(UserDto userDto);
    List<UserDto> getAllUsers();
    void saveFileDetails(MultipartFile file) throws Exception;
}
