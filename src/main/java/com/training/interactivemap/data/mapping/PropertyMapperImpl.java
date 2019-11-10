package com.training.interactivemap.data.mapping;

import com.training.interactivemap.data.dto.PropertyDto;
import com.training.interactivemap.data.entity.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapperImpl implements PropertyMapper {
    @Override
    public PropertyDto propertyToDto(Property property) {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setRooms(property.getRooms());
        propertyDto.setArea(property.getArea());
        propertyDto.setDescription(property.getDescription());
        propertyDto.setAddress(property.getAddress());
        propertyDto.setxAxis(property.getxAxis());
        propertyDto.setyAxis(property.getyAxis());
        return propertyDto;
    }

    @Override
    public Property dtoToProperty(PropertyDto propertyDto) {
        Property property = new Property();
        property.setId(propertyDto.getId());
        property.setRooms(propertyDto.getRooms());
        property.setArea(propertyDto.getArea());
        property.setDescription(propertyDto.getDescription());
        property.setAddress(propertyDto.getAddress());
        property.setxAxis(propertyDto.getxAxis());
        property.setyAxis(propertyDto.getyAxis());
        return property;
    }
}