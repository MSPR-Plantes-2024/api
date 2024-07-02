package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.user.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")// injection de UserTypeMapper pour mapper UserType.
public interface UserMinimalMapper {
    User fromDto(UserMinimalDTO userMinimalDto);
    //List<User> fromDtos(UserMinimalDTO userMinimalDto);
    UserMinimalDTO toMinimalDto(User user);
    List<UserMinimalDTO> toMinimalDtos(List<User> users);
}
