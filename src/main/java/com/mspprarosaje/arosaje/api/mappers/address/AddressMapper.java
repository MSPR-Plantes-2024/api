package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address fromDto(AddressDTO addressDto);

    List<Address> fromDtos(List<AddressDTO> addressDto);

    AddressDTO toDto(Address address);

    List<AddressDTO> toDtos(List<Address> addresses);
}
