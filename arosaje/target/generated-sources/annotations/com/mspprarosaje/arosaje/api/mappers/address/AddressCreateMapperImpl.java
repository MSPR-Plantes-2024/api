package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.address.AddressCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T02:32:36+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class AddressCreateMapperImpl implements AddressCreateMapper {

    @Override
    public Address fromDto(AddressCreateDTO addressCreateDto) {
        if ( addressCreateDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setPostalAddress( addressCreateDto.getPostalAddress() );
        address.setCity( addressCreateDto.getCity() );
        address.setZipCode( addressCreateDto.getZipCode() );
        address.setOtherInfo( addressCreateDto.getOtherInfo() );
        address.setUser( userDTOToUser( addressCreateDto.getUser() ) );

        return address;
    }

    @Override
    public List<Address> fromDtos(List<AddressCreateDTO> addressCreateDto) {
        if ( addressCreateDto == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressCreateDto.size() );
        for ( AddressCreateDTO addressCreateDTO : addressCreateDto ) {
            list.add( fromDto( addressCreateDTO ) );
        }

        return list;
    }

    @Override
    public AddressCreateDTO toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressCreateDTO.AddressCreateDTOBuilder addressCreateDTO = AddressCreateDTO.builder();

        addressCreateDTO.postalAddress( address.getPostalAddress() );
        addressCreateDTO.city( address.getCity() );
        addressCreateDTO.zipCode( address.getZipCode() );
        addressCreateDTO.otherInfo( address.getOtherInfo() );
        addressCreateDTO.user( userToUserDTO( address.getUser() ) );

        return addressCreateDTO.build();
    }

    @Override
    public List<AddressCreateDTO> toDtos(List<Address> address) {
        if ( address == null ) {
            return null;
        }

        List<AddressCreateDTO> list = new ArrayList<AddressCreateDTO>( address.size() );
        for ( Address address1 : address ) {
            list.add( toDto( address1 ) );
        }

        return list;
    }

    protected User userDTOToUser(UserDTO userDTO) {
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

    protected UserDTO userToUserDTO(User user) {
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
}
