package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.address.AddressUpdateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserDTO;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.model.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-26T21:37:51+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
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

    protected UserType userTypeDTOToUserType(UserTypeDTO userTypeDTO) {
        if ( userTypeDTO == null ) {
            return null;
        }

        UserType userType = new UserType();

        userType.setId( userTypeDTO.getId() );
        userType.setName( userTypeDTO.getName() );

        return userType;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setFirstName( userDTO.getFirstName() );
        user.setLastName( userDTO.getLastName() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );
        user.setUserType( userTypeDTOToUserType( userDTO.getUserType() ) );

        return user;
    }

    protected UserTypeDTO userTypeToUserTypeDTO(UserType userType) {
        if ( userType == null ) {
            return null;
        }

        UserTypeDTO.UserTypeDTOBuilder userTypeDTO = UserTypeDTO.builder();

        userTypeDTO.id( userType.getId() );
        userTypeDTO.name( userType.getName() );

        return userTypeDTO.build();
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
        userDTO.userType( userTypeToUserTypeDTO( user.getUserType() ) );

        return userDTO.build();
    }
}
