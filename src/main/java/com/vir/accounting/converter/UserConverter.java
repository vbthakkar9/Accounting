package com.vir.accounting.converter;

import com.vir.accounting.dto.UserDto;
import com.vir.accounting.entity.User;

/**
 * 
 * @author Admin
 *
 */
public class UserConverter {
	public static User dtoToEntity(UserDto userDto) {
		User user = new User(userDto.getClientId(), userDto.getClientName(), userDto.getClientCode(), userDto.getBseCode(), userDto.getNseCode(), userDto.getFnoCode());;
		user.setClientId(userDto.getClientId());
		return user;
	}

	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto(user.getClientId(), user.getClientName(), user.getClientCode(), user.getBseCode(), user.getNseCode(), user.getFnoCode());
		return userDto;
	}
}
