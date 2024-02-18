package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.model.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-19T00:34:00+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserCreateMapperImpl implements UserCreateMapper {

    @Override
    public User fromDto(UserCreateDTO userCreateDto) {
        if ( userCreateDto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userCreateDto.getFirstName() );
        user.setLastName( userCreateDto.getLastName() );
        user.setEmail( userCreateDto.getEmail() );
        user.setPassword( userCreateDto.getPassword() );
        user.setUserType( userTypeDTOToUserType( userCreateDto.getUserType() ) );

        return user;
    }

    @Override
    public UserCreateDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserCreateDTO.UserCreateDTOBuilder userCreateDTO = UserCreateDTO.builder();

        userCreateDTO.firstName( user.getFirstName() );
        userCreateDTO.lastName( user.getLastName() );
        userCreateDTO.email( user.getEmail() );
        userCreateDTO.password( user.getPassword() );
        userCreateDTO.userType( userTypeToUserTypeDTO( user.getUserType() ) );

        return userCreateDTO.build();
    }

    @Override
    public List<UserCreateDTO> toDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserCreateDTO> list = new ArrayList<UserCreateDTO>( users.size() );
        for ( User user : users ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    protected UserType userTypeDTOToUserType(UserTypeDTO userTypeDTO) {
        if ( userTypeDTO == null ) {
            return null;
        }

        UserType userType = new UserType();

        userType.setId( userTypeDTO.getId() );
        userType.setName( userTypeDTO.getName() );

        return userType;
    }

    protected UserTypeDTO userTypeToUserTypeDTO(UserType userType) {
        if ( userType == null ) {
            return null;
        }

        UserTypeDTO.UserTypeDTOBuilder userTypeDTO = UserTypeDTO.builder();

        userTypeDTO.id( userType.getId() );
        userTypeDTO.name( userType.getName() );

        return userTypeDTO.build();
    }
}
