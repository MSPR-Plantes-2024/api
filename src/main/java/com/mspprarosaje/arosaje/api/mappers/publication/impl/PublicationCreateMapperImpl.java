package com.mspprarosaje.arosaje.api.mappers.publication.impl;

import com.mspprarosaje.arosaje.api.dto.publication.PublicationCreateDTO;
import com.mspprarosaje.arosaje.api.mappers.publication.PublicationCreateMapper;
import com.mspprarosaje.arosaje.model.*;
import com.mspprarosaje.arosaje.services.AddressService;
import com.mspprarosaje.arosaje.services.PlantService;
import com.mspprarosaje.arosaje.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PublicationCreateMapperImpl implements PublicationCreateMapper {

    final AddressService addressService;
    final UserService userService;
    final PlantService plantService;
    @Override
    public Publication fromDto(PublicationCreateDTO publicationCreateDTO) {
        Publication publication = new Publication();

        Address address = new Address();
        User publisher = new User();
        List<Plant> plants = new ArrayList<>();

        if (publicationCreateDTO.getAddressId() != 0 && addressService.getAddressById(publicationCreateDTO.getAddressId()).isPresent()) {
            address = addressService.getAddressById(publicationCreateDTO.getAddressId()).get();
        } else {address = null;}

        if (publicationCreateDTO.getPublisherId() != 0 && userService.getUserAccountById(publicationCreateDTO.getPublisherId()).isPresent()) {
            publisher = userService.getUserAccountById(publicationCreateDTO.getPublisherId()).get();
        } else {publisher = null;}

        for (Integer plantId : publicationCreateDTO.getPlantsId()) {
            if (plantService.getPlantById(plantId).isPresent()) {
                plants.add(plantService.getPlantById(plantId).get());
            }
        }

        publication.setDescription(publicationCreateDTO.getDescription());
        publication.setAddress(address);
        publication.setPublisher(publisher);
        publication.setPlants(plants);

        return publication;
    }
}
