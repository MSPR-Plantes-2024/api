package com.mspprarosaje.arosaje.api.mappers.publication.impl;

import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationCreateDTO;
import com.mspprarosaje.arosaje.api.mappers.plant.PlantMapper;
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

        if (publicationCreateDTO.getAddress() != null) {
			if(addressService.getAddressById(publicationCreateDTO.getAddress().getId()).isPresent()) {
				address = addressService.getAddressById(publicationCreateDTO.getAddress().getId()).get();
			} else {address = null;}
        } else {address = null;}

        if (publicationCreateDTO.getPublisher() != null ) {
			if(userService.getUserAccountById(publicationCreateDTO.getPublisher().getId()).isPresent()) {
				publisher = userService.getUserAccountById(publicationCreateDTO.getPublisher().getId()).get();
			} else {publisher = null;}
        } else {publisher = null;}

		if(publicationCreateDTO.getPlants() != null) {
			for (PlantDTO plantDTO : publicationCreateDTO.getPlants()) {
				if (plantService.getPlantById(plantDTO.getId()).isPresent()) {
					plants.add(plantService.getPlantById(plantDTO.getId()).get());
				}
			}
		}

        publication.setDescription(publicationCreateDTO.getDescription());
        publication.setAddress(address);
        publication.setPublisher(publisher);
        publication.setPlants(plants);
		if(publicationCreateDTO.getStartingDate() != null){publication.setStartingDate(publicationCreateDTO.getStartingDate());};
		if(publicationCreateDTO.getEndingDate() != null){publication.setEndingDate(publicationCreateDTO.getEndingDate());}

        return publication;
    }
}
