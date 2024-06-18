package com.mspprarosaje.arosaje.api.mappers.picture;

import com.mspprarosaje.arosaje.api.dto.picture.PictureDTO;
import com.mspprarosaje.arosaje.model.Picture;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T15:25:19+0200",
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
