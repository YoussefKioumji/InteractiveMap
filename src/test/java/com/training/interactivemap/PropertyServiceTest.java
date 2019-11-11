package com.training.interactivemap;

import com.training.interactivemap.data.entity.Property;
import com.training.interactivemap.data.repository.PropertyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceTest {
    private static final int PAGE = 1;
    private static final int PAGE_SIZE_FOR_ARTICLES = 2;

    @Mock
    private PropertyRepository propertyRepository;

    private List<Property> properties;

    @Before
    public void setUp() {
        properties = initPropertyList();
    }

    @Test
    public void getAllPropertiesSeparatedByPages() {
//        when(propertyRepository.findAll(PageRequest.of(PAGE - 1, PAGE_SIZE_FOR_ARTICLES))).thenReturn(properties);
    }

    private List<Property> initPropertyList() {
        return null;
    }
}