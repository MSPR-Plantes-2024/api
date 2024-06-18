package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.model.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T15:25:20+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromDto(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDTO.getId() );
        user.firstName( userDTO.getFirstName() );
        user.lastName( userDTO.getLastName() );
        user.email( userDTO.getEmail() );
        user.password( userDTO.getPassword() );
        user.userType( userDTO.getUserType() );

        return user.build();
    }

    @Override
    public List<User> fromDtos(List<UserDTO> userDto) {
        if ( userDto == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDto.size() );
        for ( UserDTO userDTO : userDto ) {
            list.add( fromDto( userDTO ) );
        }

        return list;
    }

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( user.getId() );
        userDTO.firstName( user.getFirstName() );
        userDTO.lastName( user.getLastName() );
        userDTO.email( user.getEmail() );
        userDTO.password( user.getPassword() );
        userDTO.userType( user.getUserType() );

        return userDTO.build();
    }

    @Override
    public List<UserDTO> toDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( toDto( user ) );
        }

        return list;
    }
}
