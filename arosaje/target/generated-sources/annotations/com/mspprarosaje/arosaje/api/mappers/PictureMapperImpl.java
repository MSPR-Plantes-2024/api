package com.mspprarosaje.arosaje.api.mappers;

import com.mspprarosaje.arosaje.api.dto.PictureDTO;
import com.mspprarosaje.arosaje.model.Picture;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T02:32:36+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class PictureMapperImpl implements PictureMapper {

    @Override
    public Picture fromDto(PictureDTO pictureDTO) {
        if ( pictureDTO == null ) {
            return null;
        }

        Picture picture = new Picture();

        picture.setId( pictureDTO.getId() );
        picture.setUrl( pictureDTO.getUrl() );
        picture.setCreationDate( pictureDTO.getCreationDate() );

        return picture;
    }

    @Override
    public List<Picture> fromDtos(List<PictureDTO> picturesDTO) {
        if ( picturesDTO == null ) {
            return null;
        }

        List<Picture> list = new ArrayList<Picture>( picturesDTO.size() );
        for ( PictureDTO pictureDTO : picturesDTO ) {
            list.add( fromDto( pictureDTO ) );
        }

        return list;
    }

    @Override
    public PictureDTO toDto(Picture picture) {
        if ( picture == null ) {
            return null;
        }

        PictureDTO.PictureDTOBuilder pictureDTO = PictureDTO.builder();

        pictureDTO.id( picture.getId() );
        pictureDTO.url( picture.getUrl() );
        pictureDTO.creationDate( picture.getCreationDate() );

        return pictureDTO.build();
    }

    @Override
    public List<PictureDTO> toDtos(List<Picture> pictures) {
        if ( pictures == null ) {
            return null;
        }

        List<PictureDTO> list = new ArrayList<PictureDTO>( pictures.size() );
        for ( Picture picture : pictures ) {
            list.add( toDto( picture ) );
        }

        return list;
    }
}
