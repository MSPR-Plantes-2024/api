package com.mspprarosaje.arosaje.api.mappers.plant.impl;

import com.mspprarosaje.arosaje.api.dto.plant.PlantCreateDTO;
import com.mspprarosaje.arosaje.api.mappers.plant.PlantCreateMapper;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.PlantCondition;
import com.mspprarosaje.arosaje.model.user.User;
import com.mspprarosaje.arosaje.services.AddressService;
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
    final Integer DEFAULT_PLANT_CONDITION = 1;
    @Override
    public Plant fromDto(PlantCreateDTO plantCreateDTO) {
        Plant plant = new Plant();

        PlantCondition plantCondition = new PlantCondition();
        Address address = new Address();
        User user = new User();

        if (plantCreateDTO.getPlantConditionId() != 0 && plantConditionService.getPlantConditionById(plantCreateDTO.getPlantConditionId()).isPresent()) {
            plantCondition = plantConditionService.getPlantConditionById(plantCreateDTO.getPlantConditionId()).get();
        } else { plantCondition = plantConditionService.getPlantConditionById(DEFAULT_PLANT_CONDITION).get();}

        if(plantCreateDTO.getAddressId() != 0 && addressService.getAddressById(plantCreateDTO.getAddressId()).isPresent()) {
            address = addressService.getAddressById(plantCreateDTO.getAddressId()).get();
        } else { address = null;}

        if (plantCreateDTO.getUserId() != 0 && userService.getUserAccountById(plantCreateDTO.getUserId()).isPresent()) {
            user = userService.getUserAccountById(plantCreateDTO.getUserId()).get();
        } else { user = null;}

        plant.setName(plantCreateDTO.getName());
        plant.setDescription(plantCreateDTO.getDescription());
        //TODO : Mettre en place la création d image
        plant.setPicture(null);
        plant.setPlantCondition(plantCondition);
        plant.setAddress(address);
        plant.setUser(user);
        return plant;
    }
}
