package com.training.interactivemap.data.mapping;

import com.training.interactivemap.data.dto.PictureDto;
import com.training.interactivemap.data.entity.Picture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PictureMapper {
    PictureDto pictureToDto(Picture picture);

//    @InheritInverseConfiguration
//    Picture dtoToPicture(PictureDto pictureDto);
}