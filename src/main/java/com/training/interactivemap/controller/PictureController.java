package com.training.interactivemap.controller;

import com.training.interactivemap.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping(value = "picture/{id}")
    public ResponseEntity<byte[]> findPicturesByPropertyId(@PathVariable Integer id) {
        return new ResponseEntity<>(pictureService.findPicturesByPropertyId(id).get().getPicture(), HttpStatus.OK);
    }
}