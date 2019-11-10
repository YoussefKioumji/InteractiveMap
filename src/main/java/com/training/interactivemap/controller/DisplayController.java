package com.training.interactivemap.controller;

import com.training.interactivemap.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DisplayController {
    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = {"/", "/interactive-map/home"})
    public ModelAndView showHomePage() {
        return new ModelAndView("home");
    }

    @RequestMapping("/interactive-map/showRange")
    public ModelAndView showRangePage() {
        return new ModelAndView("rangePage");
    }

    @RequestMapping(value = "/interactive-map/deletePage")
    public ModelAndView showDeletePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("properties", propertyService.findAllPropertiesWithoutPagination());
        modelAndView.setViewName("deletePage");
        return modelAndView;
    }

    @RequestMapping(value = "/interactive-map/createPage")
    public ModelAndView showCreatePage() {
        return new ModelAndView("createPage");
    }

    @RequestMapping(value = "/interactive-map/updatePage")
    public ModelAndView showUpdatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("properties", propertyService.findAllPropertiesWithoutPagination());
        modelAndView.setViewName("updatePage");
        return modelAndView;
    }
}