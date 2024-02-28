package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.address.AddressUpdateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.model.Address;
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
public class AddressUpdateMapperImpl implements AddressUpdateMapper {

    @Override
    public Address fromDto(AddressUpdateDTO addressUpdateDto) {
        if ( addressUpdateDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressUpdateDto.getId() );
        address.setPostalAddress( addressUpdateDto.getPostalAddress() );
        address.setCity( addressUpdateDto.getCity() );
        address.setZipCode( addressUpdateDto.getZipCode() );
        address.setOtherInfo( addressUpdateDto.getOtherInfo() );
        address.setUser( userDTOToUser( addressUpdateDto.getUser() ) );

        return address;
    }

    @Override
    public List<Address> fromDtos(List<AddressUpdateDTO> addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDto.size() );
        for ( AddressUpdateDTO addressUpdateDTO : addressDto ) {
            list.add( fromDto( addressUpdateDTO ) );
        }

        return list;
    }

    @Override
    public AddressUpdateDTO toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressUpdateDTO.AddressUpdateDTOBuilder addressUpdateDTO = AddressUpdateDTO.builder();

        addressUpdateDTO.id( address.getId() );
        addressUpdateDTO.postalAddress( address.getPostalAddress() );
        addressUpdateDTO.city( address.getCity() );
        addressUpdateDTO.zipCode( address.getZipCode() );
        addressUpdateDTO.otherInfo( address.getOtherInfo() );
        addressUpdateDTO.user( userToUserDTO( address.getUser() ) );

        return addressUpdateDTO.build();
    }

    @Override
    public List<AddressUpdateDTO> toDtos(List<Address> address) {
        if ( address == null ) {
            return null;
        }

        List<AddressUpdateDTO> list = new ArrayList<AddressUpdateDTO>( address.size() );
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
