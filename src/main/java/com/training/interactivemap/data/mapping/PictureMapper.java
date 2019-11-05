package com.training.interactivemap.data.mapping;

import com.training.interactivemap.data.dto.PictureDto;
import com.training.interactivemap.data.entity.Picture;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PictureMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "picture", target = "picture"),
            @Mapping(source = "type", target = "type")
    })
    PictureDto pictureToDto(Picture picture);

    @InheritInverseConfiguration
    Picture dtoToPicture(PictureDto pictureDto);
}