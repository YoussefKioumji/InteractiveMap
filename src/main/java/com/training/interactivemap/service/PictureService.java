package com.training.interactivemap.service;

import com.training.interactivemap.data.entity.Picture;
import com.training.interactivemap.data.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    public Optional<Picture> findPicturesByPropertyId(Integer id) {
        return pictureRepository.findById(id);
    }
}