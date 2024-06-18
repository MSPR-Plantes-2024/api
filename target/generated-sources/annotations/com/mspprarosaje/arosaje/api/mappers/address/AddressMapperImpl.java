package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Address;
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
    public List<Address> fromDtos(List<AddressDTO> addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDto.size() );
        for ( AddressDTO addressDTO : addressDto ) {
            list.add( fromDto( addressDTO ) );
        }

        return list;
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
    public List<AddressDTO> toDtos(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toDto( address ) );
        }

        return list;
    }

    protected User userMinimalDTOToUser(UserMinimalDTO userMinimalDTO) {
        if ( userMinimalDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userMinimalDTO.getId() );
        user.firstName( userMinimalDTO.getFirstName() );
        user.lastName( userMinimalDTO.getLastName() );
        user.userType( userMinimalDTO.getUserType() );

        return user.build();
    }

    protected UserMinimalDTO userToUserMinimalDTO(User user) {
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
}
