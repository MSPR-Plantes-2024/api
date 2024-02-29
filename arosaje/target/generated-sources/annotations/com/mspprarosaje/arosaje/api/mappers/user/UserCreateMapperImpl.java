package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T19:56:36+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserCreateMapperImpl implements UserCreateMapper {

    @Override
    public User fromDto(UserCreateDTO userCreateDto) {
        if ( userCreateDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( userCreateDto.getFirstName() );
        user.lastName( userCreateDto.getLastName() );
        user.email( userCreateDto.getEmail() );
        user.password( userCreateDto.getPassword() );
        user.userType( userCreateDto.getUserType() );

        return user.build();
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
        userCreateDTO.userType( user.getUserType() );

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
}
