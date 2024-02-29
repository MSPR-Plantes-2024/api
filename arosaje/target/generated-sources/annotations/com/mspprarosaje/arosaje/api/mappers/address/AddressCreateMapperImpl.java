package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.address.AddressCreateDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T19:56:34+0100",
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
        address.setUser( userMinimalDTOToUser( addressCreateDto.getUser() ) );

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
        addressCreateDTO.user( userToUserMinimalDTO( address.getUser() ) );

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
