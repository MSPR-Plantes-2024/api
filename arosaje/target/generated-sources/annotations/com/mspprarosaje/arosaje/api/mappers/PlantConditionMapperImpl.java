package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
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
public class PlantConditionMapperImpl implements PlantConditionMapper {

    @Override
    public PlantConditionDTO toDto(PlantCondition plantCondition) {
        if ( plantCondition == null ) {
            return null;
        }

        PlantConditionDTO.PlantConditionDTOBuilder plantConditionDTO = PlantConditionDTO.builder();

        plantConditionDTO.id( plantCondition.getId() );
        plantConditionDTO.name( plantCondition.getName() );

        return plantConditionDTO.build();
    }

    @Override
    public PlantCondition fromDto(PlantConditionDTO plantConditionDTO) {
        if ( plantConditionDTO == null ) {
            return null;
        }

        PlantCondition plantCondition = new PlantCondition();

        plantCondition.setId( plantConditionDTO.getId() );
        plantCondition.setName( plantConditionDTO.getName() );

        return plantCondition;
    }

    @Override
    public List<PlantConditionDTO> toDtos(List<PlantCondition> plantConditions) {
        if ( plantConditions == null ) {
            return null;
        }

        List<PlantConditionDTO> list = new ArrayList<PlantConditionDTO>( plantConditions.size() );
        for ( PlantCondition plantCondition : plantConditions ) {
            list.add( toDto( plantCondition ) );
        }

        return list;
    }

    @Override
    public List<PlantCondition> fromDtos(List<PlantConditionDTO> plantConditionsDTO) {
        if ( plantConditionsDTO == null ) {
            return null;
        }

        List<PlantCondition> list = new ArrayList<PlantCondition>( plantConditionsDTO.size() );
        for ( PlantConditionDTO plantConditionDTO : plantConditionsDTO ) {
            list.add( fromDto( plantConditionDTO ) );
        }

        return list;
    }
}
