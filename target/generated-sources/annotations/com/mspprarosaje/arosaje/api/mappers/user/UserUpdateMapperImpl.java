package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserUpdateDTO;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-23T16:35:12+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class UserUpdateMapperImpl implements UserUpdateMapper {

    @Override
    public User fromDto(UserUpdateDTO userUpdateDto) {
        if ( userUpdateDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userUpdateDto.getId() );
        user.firstName( userUpdateDto.getFirstName() );
        user.lastName( userUpdateDto.getLastName() );
        user.email( userUpdateDto.getEmail() );
        user.password( userUpdateDto.getPassword() );
        user.userType( userUpdateDto.getUserType() );

        return user.build();
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
        userUpdateDTO.userType( user.getUserType() );

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
}
