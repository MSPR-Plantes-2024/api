package com.mspprarosaje.arosaje.api.mappers.plant;

import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantLessUserDTO;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.PlantCondition;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-19T16:48:55+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class PlantLessUserMapperImpl implements PlantLessUserMapper {

    @Override
    public Plant fromDto(PlantLessUserDTO plantLessUserDTO) {
        if ( plantLessUserDTO == null ) {
            return null;
        }

        Plant plant = new Plant();

        plant.setId( plantLessUserDTO.getId() );
        plant.setName( plantLessUserDTO.getName() );
        plant.setDescription( plantLessUserDTO.getDescription() );
        plant.setPicture( pictureDTOToPicture( plantLessUserDTO.getPicture() ) );
        plant.setPlantCondition( plantConditionDTOToPlantCondition( plantLessUserDTO.getPlantCondition() ) );
        plant.setAddress( adressMinimalDTOToAddress( plantLessUserDTO.getAddress() ) );

        return plant;
    }

    @Override
    public List<Plant> fromDtos(List<PlantLessUserDTO> plantLessUserDTOS) {
        if ( plantLessUserDTOS == null ) {
            return null;
        }

        List<Plant> list = new ArrayList<Plant>( plantLessUserDTOS.size() );
        for ( PlantLessUserDTO plantLessUserDTO : plantLessUserDTOS ) {
            list.add( fromDto( plantLessUserDTO ) );
        }

        return list;
    }

    @Override
    public PlantLessUserDTO toDto(Plant plant) {
        if ( plant == null ) {
            return null;
        }

        PlantLessUserDTO.PlantLessUserDTOBuilder plantLessUserDTO = PlantLessUserDTO.builder();

        plantLessUserDTO.id( plant.getId() );
        plantLessUserDTO.name( plant.getName() );
        plantLessUserDTO.description( plant.getDescription() );
        plantLessUserDTO.picture( pictureToPictureDTO( plant.getPicture() ) );
        plantLessUserDTO.plantCondition( plantConditionToPlantConditionDTO( plant.getPlantCondition() ) );
        plantLessUserDTO.address( addressToAdressMinimalDTO( plant.getAddress() ) );

        return plantLessUserDTO.build();
    }

    @Override
    public List<PlantLessUserDTO> toDtos(List<Plant> plants) {
        if ( plants == null ) {
            return null;
        }

        List<PlantLessUserDTO> list = new ArrayList<PlantLessUserDTO>( plants.size() );
        for ( Plant plant : plants ) {
            list.add( toDto( plant ) );
        }

        return list;
    }

    protected Picture pictureDTOToPicture(PictureDTO pictureDTO) {
        if ( pictureDTO == null ) {
            return null;
        }

        Picture picture = new Picture();

        picture.setId( pictureDTO.getId() );
        picture.setCreationDate( pictureDTO.getCreationDate() );

        return picture;
    }

    protected PlantCondition plantConditionDTOToPlantCondition(PlantConditionDTO plantConditionDTO) {
        if ( plantConditionDTO == null ) {
            return null;
        }

        PlantCondition plantCondition = new PlantCondition();

        plantCondition.setId( plantConditionDTO.getId() );
        plantCondition.setName( plantConditionDTO.getName() );

        return plantCondition;
    }

    protected Address adressMinimalDTOToAddress(AdressMinimalDTO adressMinimalDTO) {
        if ( adressMinimalDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( adressMinimalDTO.getId() );
        address.setPostalAddress( adressMinimalDTO.getPostalAddress() );
        address.setCity( adressMinimalDTO.getCity() );
        address.setZipCode( adressMinimalDTO.getZipCode() );
        address.setOtherInfo( adressMinimalDTO.getOtherInfo() );

        return address;
    }

    protected PictureDTO pictureToPictureDTO(Picture picture) {
        if ( picture == null ) {
            return null;
        }

        PictureDTO pictureDTO = new PictureDTO();

        pictureDTO.setId( picture.getId() );
        pictureDTO.setCreationDate( picture.getCreationDate() );

        return pictureDTO;
    }

    protected PlantConditionDTO plantConditionToPlantConditionDTO(PlantCondition plantCondition) {
        if ( plantCondition == null ) {
            return null;
        }

        PlantConditionDTO.PlantConditionDTOBuilder plantConditionDTO = PlantConditionDTO.builder();

        plantConditionDTO.id( plantCondition.getId() );
        plantConditionDTO.name( plantCondition.getName() );

        return plantConditionDTO.build();
    }

    protected AdressMinimalDTO addressToAdressMinimalDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AdressMinimalDTO.AdressMinimalDTOBuilder adressMinimalDTO = AdressMinimalDTO.builder();

        adressMinimalDTO.id( address.getId() );
        adressMinimalDTO.postalAddress( address.getPostalAddress() );
        adressMinimalDTO.city( address.getCity() );
        adressMinimalDTO.zipCode( address.getZipCode() );
        adressMinimalDTO.otherInfo( address.getOtherInfo() );

        return adressMinimalDTO.build();
    }
}
