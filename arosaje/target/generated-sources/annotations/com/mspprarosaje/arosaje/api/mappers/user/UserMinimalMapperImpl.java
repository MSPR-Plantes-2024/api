package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T02:32:35+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserMinimalMapperImpl implements UserMinimalMapper {

    @Override
    public User fromDto(UserMinimalDTO userMinimalDto) {
        if ( userMinimalDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userMinimalDto.getId() );
        user.firstName( userMinimalDto.getFirstName() );
        user.lastName( userMinimalDto.getLastName() );
        user.userType( userMinimalDto.getUserType() );

        return user.build();
    }

    @Override
    public UserMinimalDTO toMinimalDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserMinimalDTO.UserMinimalDTOBuilder userMinimalDTO = UserMinimalDTO.builder();

        userMinimalDTO.id( user.getId() );
        userMinimalDTO.firstName( user.getFirstName() );
        userMinimalDTO.lastName( user.getLastName() );
        userMinimalDTO.userType( user.getUserType() );

        return userMinimalDTO.build();
    }

    @Override
    public List<UserMinimalDTO> toMinimalDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserMinimalDTO> list = new ArrayList<UserMinimalDTO>( users.size() );
        for ( User user : users ) {
            list.add( toMinimalDto( user ) );
        }

        return list;
    }
}
