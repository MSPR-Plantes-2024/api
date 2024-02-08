package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserUpdateDTO;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T16:48:25+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserUpdateMapperImpl implements UserUpdateMapper {

    @Override
    public User fromDto(UserUpdateDTO userUpdateDTO) {
        if ( userUpdateDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userUpdateDTO.getId() );
        user.setFirstName( userUpdateDTO.getFirstName() );
        user.setLastName( userUpdateDTO.getLastName() );
        user.setEmail( userUpdateDTO.getEmail() );
        user.setPassword( userUpdateDTO.getPassword() );

        return user;
    }

    @Override
    public User fromDtos(UserUpdateDTO userUpdateDTO) {
        if ( userUpdateDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userUpdateDTO.getId() );
        user.setFirstName( userUpdateDTO.getFirstName() );
        user.setLastName( userUpdateDTO.getLastName() );
        user.setEmail( userUpdateDTO.getEmail() );
        user.setPassword( userUpdateDTO.getPassword() );

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

        return userUpdateDTO.build();
    }

    @Override
    public List<UserUpdateDTO> toMinimalDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserUpdateDTO> list = new ArrayList<UserUpdateDTO>( users.size() );
        for ( User user : users ) {
            list.add( toDto( user ) );
        }

        return list;
    }
}
