package com.mspprarosaje.arosaje.api.mappers;

import java.util.List;

import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserTypeMapper.class)// injection de UserTypeMapper pour mapper UserType.
public interface UserMapper {
	User fromDto(UserCreateDTO userDto);
	UserDTO toDto(User user);
	UserCreateDTO toCreateDto(User user); //convertit User en UserCreateDTO

	User fromDto(UserDTO userDto);

	List<UserMinimalDTO> toMinimalDtos(List<User> users);
}
