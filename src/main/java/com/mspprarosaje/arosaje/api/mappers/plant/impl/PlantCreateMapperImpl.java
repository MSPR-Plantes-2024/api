package com.mspprarosaje.arosaje.api.mappers.plant.impl;

import com.mspprarosaje.arosaje.api.dto.plant.PlantCreateDTO;
import com.mspprarosaje.arosaje.api.mappers.plant.PlantCreateMapper;
import com.mspprarosaje.arosaje.model.*;
import com.mspprarosaje.arosaje.services.AddressService;
import com.mspprarosaje.arosaje.services.PictureService;
import com.mspprarosaje.arosaje.services.PlantConditionService;
import com.mspprarosaje.arosaje.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PlantCreateMapperImpl implements PlantCreateMapper {

    final PlantConditionService plantConditionService;
    final AddressService addressService;
    final UserService userService;
	final PictureService pictureService;
    final Integer DEFAULT_PLANT_CONDITION = 1;
    @Override
    public Plant fromDto(PlantCreateDTO plantCreateDTO) {
        Plant plant = new Plant();

        PlantCondition plantCondition = new PlantCondition();
        Address address = new Address();
        User user = new User();
		Picture picture = new Picture();

        if (plantCreateDTO.getPlantCondition().getId() != 0 && plantConditionService.getPlantConditionById(plantCreateDTO.getPlantCondition().getId()).isPresent()) {
            plantCondition = plantConditionService.getPlantConditionById(plantCreateDTO.getPlantCondition().getId()).get();
        } else { plantCondition = plantConditionService.getPlantConditionById(DEFAULT_PLANT_CONDITION).get();}

        if(plantCreateDTO.getAddress().getId() != 0 && addressService.getAddressById(plantCreateDTO.getAddress().getId()).isPresent()) {
            address = addressService.getAddressById(plantCreateDTO.getAddress().getId()).get();
        } else { address = null;}

        if (plantCreateDTO.getUser().getId() != 0 && userService.getUserAccountById(plantCreateDTO.getUser().getId()).isPresent()) {
            user = userService.getUserAccountById(plantCreateDTO.getUser().getId()).get();
        } else { user = null;}

		if (plantCreateDTO.getPicture().getId() != 0 && pictureService.getPictureById(plantCreateDTO.getPicture().getId()).isPresent()) {
			picture = pictureService.getPictureById(plantCreateDTO.getPicture().getId()).get();
		} else { picture = null;}

        plant.setName(plantCreateDTO.getName());
        plant.setDescription(plantCreateDTO.getDescription());
        plant.setPicture(picture);
        plant.setPlantCondition(plantCondition);
        plant.setAddress(address);
        plant.setUser(user);
        return plant;
    }
}
