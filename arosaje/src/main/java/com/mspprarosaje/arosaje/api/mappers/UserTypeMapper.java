package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.model.UserType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserTypeMapper {
	UserType fromDto(UserTypeDTO userTypeDTO);
	List<UserType> fromDtos(List<UserTypeDTO> userTypesDTO);
	UserTypeDTO toDto(UserType userType);
	List<UserTypeDTO> toDtos(List<UserType> userTypes);
}
