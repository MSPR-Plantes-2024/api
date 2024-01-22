package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.user.UserCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-22T23:27:45+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private UserTypeMapper userTypeMapper;

    @Override
    public User fromDto(UserCreateDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );
        user.setUserType( userTypeMapper.fromDto( userDto.getUserType() ) );

        return user;
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
        userDTO.userType( userTypeMapper.toDto( user.getUserType() ) );

        return userDTO.build();
    }

    @Override
    public UserCreateDTO toCreateDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserCreateDTO.UserCreateDTOBuilder userCreateDTO = UserCreateDTO.builder();

        userCreateDTO.firstName( user.getFirstName() );
        userCreateDTO.lastName( user.getLastName() );
        userCreateDTO.email( user.getEmail() );
        userCreateDTO.password( user.getPassword() );
        userCreateDTO.userType( userTypeMapper.toDto( user.getUserType() ) );

        return userCreateDTO.build();
    }

    @Override
    public User fromDto(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );
        user.setUserType( userTypeMapper.fromDto( userDto.getUserType() ) );

        return user;
    }

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
