package com.training.interactivemap.controller;

import com.training.interactivemap.data.dto.PropertyDto;
import com.training.interactivemap.data.entity.Property;
import com.training.interactivemap.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/interactive-map")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping(value = "/properties/page={page}")
    public ModelAndView showAllProperties(@PathVariable int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("properties", propertyService.findAllProperties(page));
        modelAndView.addObject("numberOfPages", propertyService.numberOfRows());
        modelAndView.setViewName("allProperties");
        return modelAndView;
    }

    @GetMapping(value = "/range/page={page}")
    public ModelAndView showAllPropertiesWithinRange(@PathVariable int page, @RequestParam Integer x, @RequestParam Integer y) {
        ModelAndView modelAndView = new ModelAndView();
        List<Property> properties = propertyService.findAllPropertiesWithinRange(page, x, y);
        modelAndView.addObject("properties", properties);
        modelAndView.addObject("numberOfPages", properties.size() + 1);
        modelAndView.addObject("x", x);
        modelAndView.addObject("y", y);
        modelAndView.setViewName("rangeProperties");
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteById(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        propertyService.deletePropertyWithPicture(id);
        modelAndView.addObject("message", "The property has been successfully deleted");
        modelAndView.addObject("properties", propertyService.findAllPropertiesWithoutPagination());
        modelAndView.setViewName("deletePage");
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public ModelAndView createProperty(PropertyDto propertyDto, @RequestParam MultipartFile[] pictures) {
        ModelAndView modelAndView = new ModelAndView();
        if (pictures.length > 10) {
            modelAndView.addObject("message", "Cannot upload more than 10 pictures for one property");
        } else {
            propertyService.createOrUpdateProperty(propertyDto, pictures);
            modelAndView.addObject("message", "The property has been successfully created");
        }
        modelAndView.addObject("properties", propertyService.findAllPropertiesWithoutPagination());
        modelAndView.setViewName("createPage");
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public ModelAndView updateProperty(PropertyDto propertyDto, @RequestParam MultipartFile[] pictures) {
        ModelAndView modelAndView = new ModelAndView();
        if (pictures.length > 10) {
            modelAndView.addObject("message", "Cannot upload more than 10 pictures for one property");
        } else {
            propertyService.createOrUpdateProperty(propertyDto, pictures);
            modelAndView.addObject("message", "The property has been successfully updated");
        }
        modelAndView.addObject("properties", propertyService.findAllPropertiesWithoutPagination());
        modelAndView.setViewName("updatePage");
        return modelAndView;
    }
}