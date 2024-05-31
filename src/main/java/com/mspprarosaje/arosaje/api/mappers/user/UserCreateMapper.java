package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserCreateMapper {
    User fromDto(UserCreateDTO userCreateDto);
    //List<User> fromDtos(UserCreateDTO userCreateDtos);
    UserCreateDTO toDto(User user);
    List<UserCreateDTO> toDtos(List<User> users);
}
