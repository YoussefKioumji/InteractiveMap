package com.training.interactivemap.data.mapping;

import com.training.interactivemap.data.dto.PropertyDto;
import com.training.interactivemap.data.entity.Property;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    PropertyDto propertyToDto(Property property);
    Property dtoToProperty(PropertyDto propertyDto);
}