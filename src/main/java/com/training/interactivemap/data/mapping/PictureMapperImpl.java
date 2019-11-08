package com.training.interactivemap.data.mapping;

import com.training.interactivemap.data.dto.PictureDto;
import com.training.interactivemap.data.entity.Picture;
import org.springframework.stereotype.Component;

@Component
public class PictureMapperImpl implements PictureMapper {
    @Override
    public PictureDto pictureToDto(Picture picture) {
        PictureDto pictureDto = new PictureDto();
        pictureDto.setId(picture.getId());
        pictureDto.setPicture(picture.getPicture());
        pictureDto.setPropertyId(picture.getProperty().getId());
        pictureDto.setType(picture.getType());
        return pictureDto;
    }
}