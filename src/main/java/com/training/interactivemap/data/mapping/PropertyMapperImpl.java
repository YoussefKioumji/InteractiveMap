package com.training.interactivemap.data.mapping;

import com.training.interactivemap.data.dto.PictureDto;
import com.training.interactivemap.data.dto.PropertyDto;
import com.training.interactivemap.data.entity.Property;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyMapperImpl implements PropertyMapper {
    @Override
    public PropertyDto propertyToDto(Property property) {
        List<PictureDto> pictureDtoList = new ArrayList<>();
        PropertyDto propertyDto = new PropertyDto();

        propertyDto.setId(property.getId());
        propertyDto.setRooms(property.getRooms());
        propertyDto.setArea(property.getArea());
        propertyDto.setDescription(property.getDescription());
        propertyDto.setAddress(property.getAddress());
        propertyDto.setxAxis(property.getxAxis());
        propertyDto.setyAxis(property.getyAxis());
        propertyDto.setPictures(pictureDtoList);
        return propertyDto;
    }
}