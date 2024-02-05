package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-02T17:15:20+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address fromDto(AddressDTO addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setPostalAddress( addressDto.getPostalAddress() );
        address.setCity( addressDto.getCity() );
        address.setZipCode( addressDto.getZipCode() );
        address.setOtherInfo( addressDto.getOtherInfo() );
        address.setUser( userMinimalDTOToUser( addressDto.getUser() ) );

        return address;
    }

    @Override
    public AddressDTO toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO.AddressDTOBuilder addressDTO = AddressDTO.builder();

        addressDTO.id( address.getId() );
        addressDTO.postalAddress( address.getPostalAddress() );
        addressDTO.city( address.getCity() );
        addressDTO.zipCode( address.getZipCode() );
        addressDTO.otherInfo( address.getOtherInfo() );
        addressDTO.user( userToUserMinimalDTO( address.getUser() ) );

        return addressDTO.build();
    }

    @Override
    public List<AddressDTO> toDtos(List<Address> address) {
        if ( address == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( address.size() );
        for ( Address address1 : address ) {
            list.add( toDto( address1 ) );
        }

        return list;
    }

    protected User userMinimalDTOToUser(UserMinimalDTO userMinimalDTO) {
        if ( userMinimalDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userMinimalDTO.getId() );
        user.setFirstName( userMinimalDTO.getFirstName() );
        user.setLastName( userMinimalDTO.getLastName() );

        return user;
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