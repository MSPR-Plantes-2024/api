package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserUpdateDTO;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.model.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-26T22:02:11+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class UserUpdateMapperImpl implements UserUpdateMapper {

    @Override
    public User fromDto(UserUpdateDTO userUpdateDto) {
        if ( userUpdateDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userUpdateDto.getId() );
        user.setFirstName( userUpdateDto.getFirstName() );
        user.setLastName( userUpdateDto.getLastName() );
        user.setEmail( userUpdateDto.getEmail() );
        user.setPassword( userUpdateDto.getPassword() );
        user.setUserType( userTypeDTOToUserType( userUpdateDto.getUserType() ) );

        return user;
    }

    @Override
    public UserUpdateDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserUpdateDTO.UserUpdateDTOBuilder userUpdateDTO = UserUpdateDTO.builder();

        userUpdateDTO.id( user.getId() );
        userUpdateDTO.firstName( user.getFirstName() );
        userUpdateDTO.lastName( user.getLastName() );
        userUpdateDTO.email( user.getEmail() );
        userUpdateDTO.password( user.getPassword() );
        userUpdateDTO.userType( userTypeToUserTypeDTO( user.getUserType() ) );

        return userUpdateDTO.build();
    }

    @Override
    public List<UserUpdateDTO> toDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserUpdateDTO> list = new ArrayList<UserUpdateDTO>( users.size() );
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
