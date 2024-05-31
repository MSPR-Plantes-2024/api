package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PlantConditionDTO;
import com.mspprarosaje.arosaje.api.dto.address.AdressMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.api.dto.plant.PlantMinimalDTO;
import com.mspprarosaje.arosaje.api.dto.publication.PublicationDTO;
import com.mspprarosaje.arosaje.api.dto.report.ReportDTO;
import com.mspprarosaje.arosaje.api.dto.user.UserAccountDTO;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.Picture;
import com.mspprarosaje.arosaje.model.Plant;
import com.mspprarosaje.arosaje.model.PlantCondition;
import com.mspprarosaje.arosaje.model.Publication;
import com.mspprarosaje.arosaje.model.Report;
import com.mspprarosaje.arosaje.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-31T16:23:11+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public Report fromDto(ReportDTO reportDto) {
        if ( reportDto == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( reportDto.getId() );
        report.setTitle( reportDto.getTitle() );
        report.setText( reportDto.getText() );
        report.setPublishingDate( reportDto.getPublishingDate() );
        report.setPublication( publicationDTOToPublication( reportDto.getPublication() ) );
        report.setPictures( pictureDTOListToPictureList( reportDto.getPictures() ) );

        return report;
    }

    @Override
    public List<Report> fromDtos(List<ReportDTO> reportsDto) {
        if ( reportsDto == null ) {
            return null;
        }

        List<Report> list = new ArrayList<Report>( reportsDto.size() );
        for ( ReportDTO reportDTO : reportsDto ) {
            list.add( fromDto( reportDTO ) );
        }

        return list;
    }

    @Override
    public ReportDTO toDto(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDTO.ReportDTOBuilder reportDTO = ReportDTO.builder();

        reportDTO.id( report.getId() );
        reportDTO.title( report.getTitle() );
        reportDTO.text( report.getText() );
        reportDTO.publishingDate( report.getPublishingDate() );
        reportDTO.publication( publicationToPublicationDTO( report.getPublication() ) );
        reportDTO.pictures( pictureListToPictureDTOList( report.getPictures() ) );

        return reportDTO.build();
    }

    @Override
    public List<ReportDTO> toDtos(List<Report> reports) {
        if ( reports == null ) {
            return null;
        }

        List<ReportDTO> list = new ArrayList<ReportDTO>( reports.size() );
        for ( Report report : reports ) {
            list.add( toDto( report ) );
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

    protected Plant plantMinimalDTOToPlant(PlantMinimalDTO plantMinimalDTO) {
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

    protected Publication publicationDTOToPublication(PublicationDTO publicationDTO) {
        if ( publicationDTO == null ) {
            return null;
        }

        Publication publication = new Publication();

        publication.setId( publicationDTO.getId() );
        publication.setDescription( publicationDTO.getDescription() );
        publication.setCreationDate( publicationDTO.getCreationDate() );
        publication.setAddress( adressMinimalDTOToAddress( publicationDTO.getAddress() ) );
        publication.setPublisher( userAccountDTOToUser( publicationDTO.getPublisher() ) );
        publication.setGardenKeeper( userAccountDTOToUser( publicationDTO.getGardenKeeper() ) );
        publication.setPlants( plantMinimalDTOListToPlantList( publicationDTO.getPlants() ) );
        publication.setReports( fromDtos( publicationDTO.getReports() ) );

        return publication;
    }

    protected List<Picture> pictureDTOListToPictureList(List<PictureDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Picture> list1 = new ArrayList<Picture>( list.size() );
        for ( PictureDTO pictureDTO : list ) {
            list1.add( pictureDTOToPicture( pictureDTO ) );
        }

        return list1;
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

    protected PlantMinimalDTO plantToPlantMinimalDTO(Plant plant) {
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

    protected PublicationDTO publicationToPublicationDTO(Publication publication) {
        if ( publication == null ) {
            return null;
        }

        PublicationDTO.PublicationDTOBuilder publicationDTO = PublicationDTO.builder();

        publicationDTO.id( publication.getId() );
        publicationDTO.creationDate( publication.getCreationDate() );
        publicationDTO.description( publication.getDescription() );
        publicationDTO.address( addressToAdressMinimalDTO( publication.getAddress() ) );
        publicationDTO.publisher( userToUserAccountDTO( publication.getPublisher() ) );
        publicationDTO.gardenKeeper( userToUserAccountDTO( publication.getGardenKeeper() ) );
        publicationDTO.plants( plantListToPlantMinimalDTOList( publication.getPlants() ) );
        publicationDTO.reports( toDtos( publication.getReports() ) );

        return publicationDTO.build();
    }

    protected List<PictureDTO> pictureListToPictureDTOList(List<Picture> list) {
        if ( list == null ) {
            return null;
        }

        List<PictureDTO> list1 = new ArrayList<PictureDTO>( list.size() );
        for ( Picture picture : list ) {
            list1.add( pictureToPictureDTO( picture ) );
        }

        return list1;
    }
}
