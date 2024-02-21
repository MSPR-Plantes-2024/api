package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.model.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-20T13:31:37+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserTypeMapperImpl implements UserTypeMapper {

    @Override
    public UserType fromDto(UserTypeDTO userTypeDTO) {
        if ( userTypeDTO == null ) {
            return null;
        }

        UserType userType = new UserType();

        userType.setId( userTypeDTO.getId() );
        userType.setName( userTypeDTO.getName() );

        return userType;
    }

    @Override
    public List<UserType> fromDtos(List<UserTypeDTO> userTypesDTO) {
        if ( userTypesDTO == null ) {
            return null;
        }

        List<UserType> list = new ArrayList<UserType>( userTypesDTO.size() );
        for ( UserTypeDTO userTypeDTO : userTypesDTO ) {
            list.add( fromDto( userTypeDTO ) );
        }

        return list;
    }

    @Override
    public UserTypeDTO toDto(UserType userType) {
        if ( userType == null ) {
            return null;
        }

        UserTypeDTO.UserTypeDTOBuilder userTypeDTO = UserTypeDTO.builder();

        userTypeDTO.id( userType.getId() );
        userTypeDTO.name( userType.getName() );

        return userTypeDTO.build();
    }

    @Override
    public List<UserTypeDTO> toDtos(List<UserType> userTypes) {
        if ( userTypes == null ) {
            return null;
        }

        List<UserTypeDTO> list = new ArrayList<UserTypeDTO>( userTypes.size() );
        for ( UserType userType : userTypes ) {
            list.add( toDto( userType ) );
        }

        return list;
    }
}
