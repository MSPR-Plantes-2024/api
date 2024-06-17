package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.address.AddressUpdateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T12:33:07+0200",
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
        address.setUser( userMinimalDTOToUser( addressUpdateDto.getUser() ) );

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
        addressUpdateDTO.user( userToUserMinimalDTO( address.getUser() ) );

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
