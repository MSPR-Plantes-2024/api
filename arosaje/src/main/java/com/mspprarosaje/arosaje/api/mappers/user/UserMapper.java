package com.mspprarosaje.arosaje.api.mappers.user;

import java.util.List;

import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User fromDto(UserDTO userDTO);
	List<User> fromDtos(List<UserDTO> userDto);
	UserDTO toDto(User user);
	List<UserDTO> toDtos(List<User> users);
}
