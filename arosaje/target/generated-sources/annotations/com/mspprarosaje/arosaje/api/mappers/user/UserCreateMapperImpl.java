package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-31T17:21:15+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserCreateMapperImpl implements UserCreateMapper {

    @Override
    public User fromDto(UserCreateDTO userCreateDTO) {
        if ( userCreateDTO == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userCreateDTO.getFirstName() );
        user.setLastName( userCreateDTO.getLastName() );
        user.setEmail( userCreateDTO.getEmail() );
        user.setPassword( userCreateDTO.getPassword() );

        return user;
    }

    @Override
    public User fromDtos(UserCreateDTO userCreateDTOs) {
        if ( userCreateDTOs == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userCreateDTOs.getFirstName() );
        user.setLastName( userCreateDTOs.getLastName() );
        user.setEmail( userCreateDTOs.getEmail() );
        user.setPassword( userCreateDTOs.getPassword() );

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

        return userCreateDTO.build();
    }

    @Override
    public List<UserCreateDTO> toMinimalDtos(List<User> users) {
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
