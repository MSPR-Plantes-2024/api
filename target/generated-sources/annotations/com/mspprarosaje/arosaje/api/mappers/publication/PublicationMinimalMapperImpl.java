package com.mspprarosaje.arosaje.api.mappers.publication;

import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.report.ReportDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserAccountDTO;
import com.mspprarosaje.arosaje.api.mappers.picture.PictureMapper;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.PlantCondition;
import com.mspprarosaje.arosaje.model.Publication;
import com.mspprarosaje.arosaje.model.Report;
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
public class PublicationMinimalMapperImpl implements PublicationMinimalMapper {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public Publication fromDto(PublicationMinimalDTO publicationMinimalDTO) {
        if ( publicationMinimalDTO == null ) {
            return null;
        }

        Publication publication = new Publication();

        publication.setId( publicationMinimalDTO.getId() );
        publication.setDescription( publicationMinimalDTO.getDescription() );
        publication.setCreationDate( publicationMinimalDTO.getCreationDate() );
        publication.setStartingDate( publicationMinimalDTO.getStartingDate() );
        publication.setEndingDate( publicationMinimalDTO.getEndingDate() );
        publication.setAddress( adressMinimalDTOToAddress( publicationMinimalDTO.getAddress() ) );
        publication.setGardenKeeper( userAccountDTOToUser( publicationMinimalDTO.getGardenKeeper() ) );
        publication.setPlants( plantMinimalDTOListToPlantList( publicationMinimalDTO.getPlants() ) );
        publication.setReports( reportDTOListToReportList( publicationMinimalDTO.getReports() ) );

        return publication;
    }

    @Override
    public List<Publication> fromDtos(List<PublicationMinimalDTO> publicationMinimalDTOS) {
        if ( publicationMinimalDTOS == null ) {
            return null;
        }

        List<Publication> list = new ArrayList<Publication>( publicationMinimalDTOS.size() );
        for ( PublicationMinimalDTO publicationMinimalDTO : publicationMinimalDTOS ) {
            list.add( fromDto( publicationMinimalDTO ) );
        }

        return list;
    }

    @Override
    public PublicationMinimalDTO toDto(Publication publication) {
        if ( publication == null ) {
            return null;
        }

        PublicationMinimalDTO.PublicationMinimalDTOBuilder publicationMinimalDTO = PublicationMinimalDTO.builder();

        publicationMinimalDTO.id( publication.getId() );
        publicationMinimalDTO.creationDate( publication.getCreationDate() );
        publicationMinimalDTO.startingDate( publication.getStartingDate() );
        publicationMinimalDTO.endingDate( publication.getEndingDate() );
        publicationMinimalDTO.description( publication.getDescription() );
        publicationMinimalDTO.address( addressToAdressMinimalDTO( publication.getAddress() ) );
        publicationMinimalDTO.gardenKeeper( userToUserAccountDTO( publication.getGardenKeeper() ) );
        publicationMinimalDTO.plants( plantListToPlantMinimalDTOList( publication.getPlants() ) );
        publicationMinimalDTO.reports( reportListToReportDTOList( publication.getReports() ) );

        return publicationMinimalDTO.build();
    }

    @Override
    public List<PublicationMinimalDTO> toDtos(List<Publication> publications) {
        if ( publications == null ) {
            return null;
        }

        List<PublicationMinimalDTO> list = new ArrayList<PublicationMinimalDTO>( publications.size() );
        for ( Publication publication : publications ) {
            list.add( toDto( publication ) );
        }

        return list;
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

    protected User userAccountDTOToUser(UserAccountDTO userAccountDTO) {
        if ( userAccountDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userAccountDTO.getId() );
        user.firstName( userAccountDTO.getFirstName() );
        user.lastName( userAccountDTO.getLastName() );
        user.userType( userAccountDTO.getUserType() );

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

    protected Plant plantMinimalDTOToPlant(PlantMinimalDTO plantMinimalDTO) {
        if ( plantMinimalDTO == null ) {
            return null;
        }

        Plant plant = new Plant();

        plant.setId( plantMinimalDTO.getId() );
        plant.setName( plantMinimalDTO.getName() );
        plant.setDescription( plantMinimalDTO.getDescription() );
        plant.setPicture( pictureMapper.fromDto( plantMinimalDTO.getPicture() ) );
        plant.setPlantCondition( plantConditionDTOToPlantCondition( plantMinimalDTO.getPlantCondition() ) );

        return plant;
    }

    protected List<Plant> plantMinimalDTOListToPlantList(List<PlantMinimalDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Plant> list1 = new ArrayList<Plant>( list.size() );
        for ( PlantMinimalDTO plantMinimalDTO : list ) {
            list1.add( plantMinimalDTOToPlant( plantMinimalDTO ) );
        }

        return list1;
    }

    protected List<Report> reportDTOListToReportList(List<ReportDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Report> list1 = new ArrayList<Report>( list.size() );
        for ( ReportDTO reportDTO : list ) {
            list1.add( reportDTOToReport( reportDTO ) );
        }

        return list1;
    }

    protected Publication publicationDTOToPublication(PublicationDTO publicationDTO) {
        if ( publicationDTO == null ) {
            return null;
        }

        Publication publication = new Publication();

        publication.setId( publicationDTO.getId() );
        publication.setDescription( publicationDTO.getDescription() );
        publication.setCreationDate( publicationDTO.getCreationDate() );
        publication.setStartingDate( publicationDTO.getStartingDate() );
        publication.setEndingDate( publicationDTO.getEndingDate() );
        publication.setAddress( adressMinimalDTOToAddress( publicationDTO.getAddress() ) );
        publication.setPublisher( userAccountDTOToUser( publicationDTO.getPublisher() ) );
        publication.setGardenKeeper( userAccountDTOToUser( publicationDTO.getGardenKeeper() ) );
        publication.setPlants( plantMinimalDTOListToPlantList( publicationDTO.getPlants() ) );
        publication.setReports( reportDTOListToReportList( publicationDTO.getReports() ) );

        return publication;
    }

    protected Report reportDTOToReport(ReportDTO reportDTO) {
        if ( reportDTO == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( reportDTO.getId() );
        report.setTitle( reportDTO.getTitle() );
        report.setText( reportDTO.getText() );
        report.setPublishingDate( reportDTO.getPublishingDate() );
        report.setPublication( publicationDTOToPublication( reportDTO.getPublication() ) );
        report.setPictures( pictureMapper.fromDtos( reportDTO.getPictures() ) );

        return report;
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

    protected UserAccountDTO userToUserAccountDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserAccountDTO.UserAccountDTOBuilder userAccountDTO = UserAccountDTO.builder();

        userAccountDTO.id( user.getId() );
        userAccountDTO.firstName( user.getFirstName() );
        userAccountDTO.lastName( user.getLastName() );
        userAccountDTO.userType( user.getUserType() );

        return userAccountDTO.build();
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

    protected PlantMinimalDTO plantToPlantMinimalDTO(Plant plant) {
        if ( plant == null ) {
            return null;
        }

        PlantMinimalDTO.PlantMinimalDTOBuilder plantMinimalDTO = PlantMinimalDTO.builder();

        plantMinimalDTO.id( plant.getId() );
        plantMinimalDTO.name( plant.getName() );
        plantMinimalDTO.description( plant.getDescription() );
        plantMinimalDTO.picture( pictureMapper.toDto( plant.getPicture() ) );
        plantMinimalDTO.plantCondition( plantConditionToPlantConditionDTO( plant.getPlantCondition() ) );

        return plantMinimalDTO.build();
    }

    protected List<PlantMinimalDTO> plantListToPlantMinimalDTOList(List<Plant> list) {
        if ( list == null ) {
            return null;
        }

        List<PlantMinimalDTO> list1 = new ArrayList<PlantMinimalDTO>( list.size() );
        for ( Plant plant : list ) {
            list1.add( plantToPlantMinimalDTO( plant ) );
        }

        return list1;
    }

    protected List<ReportDTO> reportListToReportDTOList(List<Report> list) {
        if ( list == null ) {
            return null;
        }

        List<ReportDTO> list1 = new ArrayList<ReportDTO>( list.size() );
        for ( Report report : list ) {
            list1.add( reportToReportDTO( report ) );
        }

        return list1;
    }

    protected PublicationDTO publicationToPublicationDTO(Publication publication) {
        if ( publication == null ) {
            return null;
        }

        PublicationDTO.PublicationDTOBuilder publicationDTO = PublicationDTO.builder();

        publicationDTO.id( publication.getId() );
        publicationDTO.creationDate( publication.getCreationDate() );
        publicationDTO.startingDate( publication.getStartingDate() );
        publicationDTO.endingDate( publication.getEndingDate() );
        publicationDTO.description( publication.getDescription() );
        publicationDTO.address( addressToAdressMinimalDTO( publication.getAddress() ) );
        publicationDTO.publisher( userToUserAccountDTO( publication.getPublisher() ) );
        publicationDTO.gardenKeeper( userToUserAccountDTO( publication.getGardenKeeper() ) );
        publicationDTO.plants( plantListToPlantMinimalDTOList( publication.getPlants() ) );
        publicationDTO.reports( reportListToReportDTOList( publication.getReports() ) );

        return publicationDTO.build();
    }

    protected ReportDTO reportToReportDTO(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDTO.ReportDTOBuilder reportDTO = ReportDTO.builder();

        reportDTO.id( report.getId() );
        reportDTO.title( report.getTitle() );
        reportDTO.text( report.getText() );
        reportDTO.publishingDate( report.getPublishingDate() );
        reportDTO.publication( publicationToPublicationDTO( report.getPublication() ) );
        reportDTO.pictures( pictureMapper.toDtos( report.getPictures() ) );

        return reportDTO.build();
    }
}
