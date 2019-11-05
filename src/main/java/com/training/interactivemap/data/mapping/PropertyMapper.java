package com.training.interactivemap.data.mapping;

import com.training.interactivemap.data.dto.PropertyDto;
import com.training.interactivemap.data.entity.Property;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = PictureMapper.class)
@Component
public interface PropertyMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "rooms", target = "rooms"),
            @Mapping(source = "area", target = "area"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "xAxis", target = "xAxis"),
            @Mapping(source = "yAxis", target = "yAxis"),
            @Mapping(source = "pictures", target = "pictures"),
    })
    PropertyDto propertyToDto(Property property);

    @InheritInverseConfiguration
    Property dtoToProperty(PropertyDto propertyDto);
}