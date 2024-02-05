package com.mspprarosaje.arosaje.api.mappers.address;

import com.mspprarosaje.arosaje.api.dto.address.AddressCreateDTO;
import com.mspprarosaje.arosaje.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressCreateMapper {
    Address fromDto(AddressCreateDTO addressCreateDto);

    //List<Address> fromDtos(List<AddressDTO> addressCreateDto);

    AddressCreateDTO toDto(Address address);

    List<AddressCreateDTO> toDtos(List<Address> address);
}
