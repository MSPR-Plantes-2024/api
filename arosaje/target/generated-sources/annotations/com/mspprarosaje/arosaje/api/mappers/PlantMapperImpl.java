package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PictureDTO;
import com.mspprarosaje.arosaje.api.dto.PlantDTO;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.model.Plant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T11:36:16+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class PlantMapperImpl implements PlantMapper {

    @Override
    public Plant fromDto(PlantDTO plantDTO) {
        if ( plantDTO == null ) {
            return null;
        }

        Plant plant = new Plant();

        plant.setPicture( pictureDTOToPicture( plantDTO.getPictureDTO() ) );
        plant.setId( plantDTO.getId() );
        plant.setName( plantDTO.getName() );
        plant.setDescription( plantDTO.getDescription() );

        return plant;
    }

    @Override
    public List<Plant> fromDtos(List<PlantDTO> plantsDTO) {
        if ( plantsDTO == null ) {
            return null;
        }

        List<Plant> list = new ArrayList<Plant>( plantsDTO.size() );
        for ( PlantDTO plantDTO : plantsDTO ) {
            list.add( fromDto( plantDTO ) );
        }

        return list;
    }

    @Override
    public PlantDTO toDto(Plant plant) {
        if ( plant == null ) {
            return null;
        }

        PlantDTO.PlantDTOBuilder plantDTO = PlantDTO.builder();

        plantDTO.pictureDTO( pictureToPictureDTO( plant.getPicture() ) );
        plantDTO.id( plant.getId() );
        plantDTO.name( plant.getName() );
        plantDTO.description( plant.getDescription() );

        return plantDTO.build();
    }

    @Override
    public List<PlantDTO> toDtos(List<Plant> plants) {
        if ( plants == null ) {
            return null;
        }

        List<PlantDTO> list = new ArrayList<PlantDTO>( plants.size() );
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
        picture.setUrl( pictureDTO.getUrl() );
        picture.setCreationDate( pictureDTO.getCreationDate() );

        return picture;
    }

    protected PictureDTO pictureToPictureDTO(Picture picture) {
        if ( picture == null ) {
            return null;
        }

        PictureDTO.PictureDTOBuilder pictureDTO = PictureDTO.builder();

        pictureDTO.id( picture.getId() );
        pictureDTO.url( picture.getUrl() );
        pictureDTO.creationDate( picture.getCreationDate() );

        return pictureDTO.build();
    }
}
