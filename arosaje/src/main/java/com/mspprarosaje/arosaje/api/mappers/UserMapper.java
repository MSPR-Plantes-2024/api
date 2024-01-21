package com.mspprarosaje.arosaje.api.mappers;

import java.util.List;

import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User fromDto(UserDTO userDto);

	List<User> fromDtos(List<UserDTO> usersDto);

	UserDTO toDto(User user);

	List<UserMinimalDTO> toMinimalDtos(List<User> users);
}
