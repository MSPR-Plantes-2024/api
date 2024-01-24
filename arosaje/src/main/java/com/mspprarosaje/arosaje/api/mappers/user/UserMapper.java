package com.mspprarosaje.arosaje.api.mappers.user;

import java.util.List;

import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.api.mappers.UserTypeMapper;
import com.mspprarosaje.arosaje.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserTypeMapper.class)// injection de UserTypeMapper pour mapper UserType.
public interface UserMapper {
	User fromDto(UserDTO userDto);
	//List<User> fromDtos(UserDTO userDtos);
	UserDTO toDto(User user);
	//List<UserDTO> toDtos(List<User> users);
}
