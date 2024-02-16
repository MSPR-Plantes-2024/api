package com.mspprarosaje.arosaje.api.mappers.user;

import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T12:11:38+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserMinimalMapperImpl implements UserMinimalMapper {

    @Override
    public List<UserMinimalDTO> toMinimalDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserMinimalDTO> list = new ArrayList<UserMinimalDTO>( users.size() );
        for ( User user : users ) {
            list.add( userToUserMinimalDTO( user ) );
        }

        return list;
    }

    protected UserMinimalDTO userToUserMinimalDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserMinimalDTO.UserMinimalDTOBuilder userMinimalDTO = UserMinimalDTO.builder();

        userMinimalDTO.id( user.getId() );
        userMinimalDTO.firstName( user.getFirstName() );
        userMinimalDTO.lastName( user.getLastName() );

        return userMinimalDTO.build();
    }
}
