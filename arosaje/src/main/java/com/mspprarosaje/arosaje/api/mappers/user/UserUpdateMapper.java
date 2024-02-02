package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserUpdateDTO;
import com.mspprarosaje.arosaje.api.mappers.UserTypeMapper;
import com.mspprarosaje.arosaje.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserTypeMapper.class)// injection de UserTypeMapper pour mapper UserType.
public interface UserUpdateMapper {
    @Mapping(ignore = true, target = "userType")
    User fromDto(UserUpdateDTO userUpdateDTO);
    @Mapping(ignore = true, target = "userType")
    User fromDtos(UserUpdateDTO userUpdateDTO);
    @Mapping(ignore = true, target = "userType")
    UserUpdateDTO toDto(User user);
    List<UserUpdateDTO> toMinimalDtos(List<User> users);
}
