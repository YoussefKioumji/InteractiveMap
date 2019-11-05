package com.training.interactivemap.service;

import com.training.interactivemap.data.entity.Picture;
import com.training.interactivemap.data.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    public Picture storeImage(MultipartFile picture) {

        Picture dbPicture = new Picture();
        try {
            dbPicture.setPicture(picture.getBytes());
            dbPicture.setType(picture.getContentType());

            return pictureRepository.save(dbPicture);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}