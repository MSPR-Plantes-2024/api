package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.address.AddressUpdateDTO;
import com.mspprarosaje.arosaje.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressUpdateMapper {
    Address fromDto(AddressUpdateDTO addressUpdateDto);

    //List<Address> fromDtos(List<AddressDTO> addressDto);

    AddressUpdateDTO toDto(Address address);

    List<AddressUpdateDTO> toDtos(List<Address> address);
}
