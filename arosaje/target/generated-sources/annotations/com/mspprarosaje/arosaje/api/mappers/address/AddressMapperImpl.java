package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.UserTypeDTO;
import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.model.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T18:38:01+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
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

    protected UserType userTypeDTOToUserType(UserTypeDTO userTypeDTO) {
        if ( userTypeDTO == null ) {
            return null;
        }

        UserType userType = new UserType();

        userType.setId( userTypeDTO.getId() );
        userType.setName( userTypeDTO.getName() );

        return userType;
    }

    protected User userMinimalDTOToUser(UserMinimalDTO userMinimalDTO) {
        if ( userMinimalDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userMinimalDTO.getId() );
        user.setFirstName( userMinimalDTO.getFirstName() );
        user.setLastName( userMinimalDTO.getLastName() );
        user.setUserType( userTypeDTOToUserType( userMinimalDTO.getUserType() ) );

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

    protected UserMinimalDTO userToUserMinimalDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserMinimalDTO.UserMinimalDTOBuilder userMinimalDTO = UserMinimalDTO.builder();

        userMinimalDTO.id( user.getId() );
        userMinimalDTO.firstName( user.getFirstName() );
        userMinimalDTO.lastName( user.getLastName() );
        userMinimalDTO.userType( userTypeToUserTypeDTO( user.getUserType() ) );

        return userMinimalDTO.build();
    }
}
