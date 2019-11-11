package com.training.interactivemap.service;

import com.training.interactivemap.data.dto.PropertyDto;
import com.training.interactivemap.data.entity.Picture;
import com.training.interactivemap.data.entity.Property;
import com.training.interactivemap.data.mapping.PropertyMapper;
import com.training.interactivemap.data.repository.PictureRepository;
import com.training.interactivemap.data.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class PropertyService {
    private static final int PAGE_SIZE_FOR_PROPERTIES = 2;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private PropertyMapper propertyMapper;

    public List<Property> findAllProperties(int page) {
        Pageable numberOfPropertiesPerPage = PageRequest.of(page - 1, PAGE_SIZE_FOR_PROPERTIES);
        return propertyRepository.findAll(numberOfPropertiesPerPage).getContent();
    }

    public List<Property> findAllPropertiesWithoutPagination() {
        return (List<Property>)propertyRepository.findAll();
    }

    public int numberOfRows() {
        return propertyRepository.numberOfRows() / PAGE_SIZE_FOR_PROPERTIES;
    }

    public List<Property> findAllPropertiesWithinRange(int page, double x, double y) {
        if (page == 0) {
            return Collections.emptyList();
        }
        List<Property> properties = (List<Property>) propertyRepository.findAll();
        for (int i = properties.size() - 1; i >= 0; i--) {
            double xProperty = properties.get(i).getxAxis();
            double yProperty = properties.get(i).getyAxis();
            if (Math.sqrt((x - xProperty) * (x - xProperty) + (y - yProperty)*(y - yProperty)) > 10) {
                properties.remove(i);
            }
        }
        return getPage(properties, page);
    }

    private List<Property> getPage(List<Property> sourceList, int page) {
        int fromIndex = (page - 1) * PropertyService.PAGE_SIZE_FOR_PROPERTIES;
        return sourceList.subList(fromIndex, Math.min(fromIndex + PropertyService.PAGE_SIZE_FOR_PROPERTIES, sourceList.size()));
    }

    @Transactional
    public void deletePropertyWithPicture(Integer id) {
        pictureRepository.deleteByPropertyId(id);
        propertyRepository.deleteById(id);
    }

    @Transactional
    public void createOrUpdateProperty(PropertyDto propertyDto, MultipartFile[] pictures) {
        Property latestProperty = propertyRepository.save(propertyMapper.dtoToProperty(propertyDto));

        for (MultipartFile picture : pictures) {
            Picture dbPicture = new Picture();
            try {
                dbPicture.setPicture(picture.getBytes());
                dbPicture.setType(picture.getContentType());
                dbPicture.setProperty(latestProperty);
                pictureRepository.save(dbPicture);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}