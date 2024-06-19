package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserUpdateDTO;
import com.mspprarosaje.arosaje.model.user.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserUpdateMapper {
    User fromDto(UserUpdateDTO userUpdateDto);
    //List<User> fromDtos(UserUpdateDTO userUpdateDtos);
    UserUpdateDTO toDto(User user);
    List<UserUpdateDTO> toDtos(List<User> users);
}
