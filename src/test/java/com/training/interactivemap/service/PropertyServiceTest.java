package com.training.interactivemap.service;

import com.training.interactivemap.data.dto.PropertyDto;
import com.training.interactivemap.data.entity.Property;
import com.training.interactivemap.data.mapping.PropertyMapper;
import com.training.interactivemap.data.repository.PictureRepository;
import com.training.interactivemap.data.repository.PropertyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceTest {
    @InjectMocks
    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepository;

    @Mock
    private PictureRepository pictureRepository;

    @Mock
    private PropertyMapper propertyMapper;

    private Property property;
    private PropertyDto propertyDto;

    @Before
    public void setUp() {
        property = new Property();
        property.setId(1);
        propertyDto = new PropertyDto();
        propertyDto.setId(1);
    }

    @Test
    public void getAllProperties() {
        propertyService.findAllPropertiesWithoutPagination();
        verify(propertyRepository).findAll();
    }

    @Test
    public void numberOfRows() {
        propertyService.numberOfRows();
        verify(propertyRepository).numberOfRows();
    }

    @Test
    public void deletePropertyWithPicture() {
        doNothing().when(pictureRepository).deleteByPropertyId(1);
        doNothing().when(propertyRepository).deleteById(1);

        propertyService.deletePropertyWithPicture(1);
        verify(propertyRepository).deleteById(1);
        verify(pictureRepository).deleteByPropertyId(1);
    }

    @Test
    public void createOrUpdateProperty() {
        when(propertyMapper.dtoToProperty(propertyDto)).thenReturn(property);
        when(propertyMapper.propertyToDto(property)).thenReturn(propertyDto);
        when(propertyRepository.save(property)).thenReturn(property);

        propertyMapper.propertyToDto(propertyRepository.save(property));
        verify(propertyRepository).save(propertyMapper.dtoToProperty(propertyDto));
    }
}