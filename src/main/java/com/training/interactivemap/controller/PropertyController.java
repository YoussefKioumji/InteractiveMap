package com.training.interactivemap.controller;

import com.training.interactivemap.data.entity.Property;
import com.training.interactivemap.service.PictureService;
import com.training.interactivemap.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/interactive-map")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PictureService pictureService;

    @GetMapping(value = "/property")
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

//    @PostMapping(value = "/upload")
//    public Integer uploadPicture(@RequestParam("picture") MultipartFile picture) {
//        return pictureService.storeImage(picture).getId();
//    }
}