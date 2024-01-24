package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.api.mappers.UserTypeMapper;
import com.mspprarosaje.arosaje.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserTypeMapper.class)// injection de UserTypeMapper pour mapper UserType.
public interface UserCreateMapper {
    @Mapping(ignore = true, target = "userType")
    User fromDto(UserCreateDTO userCreateDTO);
    @Mapping(ignore = true, target = "userType")
    User fromDtos(UserCreateDTO userCreateDTOs);
    @Mapping(ignore = true, target = "userType")
    UserCreateDTO toDto(User user);
    List<UserCreateDTO> toMinimalDtos(List<User> users);
}
