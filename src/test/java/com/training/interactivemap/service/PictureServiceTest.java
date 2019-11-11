package com.training.interactivemap.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PictureServiceTest {
    @Mock
    private PictureService pictureService;

    @Test
    public void findPicturesByPropertyId() {
        pictureService.findPicturesByPropertyId(1);
        verify(pictureService).findPicturesByPropertyId(1);
    }
}