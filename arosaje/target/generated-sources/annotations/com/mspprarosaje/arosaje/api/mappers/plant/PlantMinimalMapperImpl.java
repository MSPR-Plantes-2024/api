package com.mspprarosaje.arosaje.api.mappers.plant;

import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantMinimalDTO;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.PlantCondition;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-11T17:13:22+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class PlantMinimalMapperImpl implements PlantMinimalMapper {

    @Override
    public Plant fromDto(PlantMinimalDTO plantMinimalDTO) {
        if ( plantMinimalDTO == null ) {
            return null;
        }

        Plant plant = new Plant();

        plant.setId( plantMinimalDTO.getId() );
        plant.setName( plantMinimalDTO.getName() );
        plant.setDescription( plantMinimalDTO.getDescription() );
        plant.setPicture( pictureDTOToPicture( plantMinimalDTO.getPicture() ) );
        plant.setPlantCondition( plantConditionDTOToPlantCondition( plantMinimalDTO.getPlantCondition() ) );

        return plant;
    }

    @Override
    public List<Plant> fromDtos(List<PlantMinimalDTO> plantMinimalDTOS) {
        if ( plantMinimalDTOS == null ) {
            return null;
        }

        List<Plant> list = new ArrayList<Plant>( plantMinimalDTOS.size() );
        for ( PlantMinimalDTO plantMinimalDTO : plantMinimalDTOS ) {
            list.add( fromDto( plantMinimalDTO ) );
        }

        return list;
    }

    @Override
    public PlantMinimalDTO toDto(Plant plant) {
        if ( plant == null ) {
            return null;
        }

        PlantMinimalDTO.PlantMinimalDTOBuilder plantMinimalDTO = PlantMinimalDTO.builder();

        plantMinimalDTO.id( plant.getId() );
        plantMinimalDTO.name( plant.getName() );
        plantMinimalDTO.description( plant.getDescription() );
        plantMinimalDTO.picture( pictureToPictureDTO( plant.getPicture() ) );
        plantMinimalDTO.plantCondition( plantConditionToPlantConditionDTO( plant.getPlantCondition() ) );

        return plantMinimalDTO.build();
    }

    @Override
    public List<PlantMinimalDTO> toDtos(List<Plant> plants) {
        if ( plants == null ) {
            return null;
        }

        List<PlantMinimalDTO> list = new ArrayList<PlantMinimalDTO>( plants.size() );
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

    protected PictureDTO pictureToPictureDTO(Picture picture) {
        if ( picture == null ) {
            return null;
        }

        PictureDTO.PictureDTOBuilder pictureDTO = PictureDTO.builder();

        pictureDTO.id( picture.getId() );
        pictureDTO.creationDate( picture.getCreationDate() );

        return pictureDTO.build();
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
}
