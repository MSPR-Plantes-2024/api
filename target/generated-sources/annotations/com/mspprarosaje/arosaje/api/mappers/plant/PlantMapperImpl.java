package com.mspprarosaje.arosaje.api.mappers.plant;

import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import com.mspprarosaje.arosaje.api.mappers.picture.PictureMapper;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.PlantCondition;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-19T16:48:55+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class PlantMapperImpl implements PlantMapper {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public Plant fromDto(PlantDTO plantDTO) {
        if ( plantDTO == null ) {
            return null;
        }

        Plant plant = new Plant();

        plant.setId( plantDTO.getId() );
        plant.setName( plantDTO.getName() );
        plant.setDescription( plantDTO.getDescription() );
        plant.setPicture( pictureMapper.fromDto( plantDTO.getPicture() ) );
        plant.setUser( userMinimalDTOToUser( plantDTO.getUser() ) );
        plant.setPlantCondition( plantConditionDTOToPlantCondition( plantDTO.getPlantCondition() ) );
        plant.setAddress( adressMinimalDTOToAddress( plantDTO.getAddress() ) );

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

        plantDTO.id( plant.getId() );
        plantDTO.name( plant.getName() );
        plantDTO.description( plant.getDescription() );
        plantDTO.picture( pictureMapper.toDto( plant.getPicture() ) );
        plantDTO.plantCondition( plantConditionToPlantConditionDTO( plant.getPlantCondition() ) );
        plantDTO.address( addressToAdressMinimalDTO( plant.getAddress() ) );
        plantDTO.user( userToUserMinimalDTO( plant.getUser() ) );

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

    protected User userMinimalDTOToUser(UserMinimalDTO userMinimalDTO) {
        if ( userMinimalDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userMinimalDTO.getId() );
        user.firstName( userMinimalDTO.getFirstName() );
        user.lastName( userMinimalDTO.getLastName() );
        user.userType( userMinimalDTO.getUserType() );

        return user.build();
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

    protected UserMinimalDTO userToUserMinimalDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserMinimalDTO.UserMinimalDTOBuilder userMinimalDTO = UserMinimalDTO.builder();

        userMinimalDTO.id( user.getId() );
        userMinimalDTO.firstName( user.getFirstName() );
        userMinimalDTO.lastName( user.getLastName() );
        userMinimalDTO.userType( user.getUserType() );

        return userMinimalDTO.build();
    }
}
