package com.training.interactivemap.controller;

import com.training.interactivemap.data.entity.Property;
import com.training.interactivemap.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/interactive-map")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping("/home")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping(value = "/properties/page={page}")
    public ModelAndView showAllProperties(@PathVariable int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("properties", propertyService.findAllProperties(page));
        modelAndView.addObject("numberOfPages", propertyService.numberOfRows());
        modelAndView.setViewName("allProperties");
        return modelAndView;
    }

    @RequestMapping("showRange")
    public ModelAndView showRangePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rangePage");
        return modelAndView;
    }

    @GetMapping(value = "/range/page={page}")
    public ModelAndView showAllPropertiesWithinRange(@PathVariable int page, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<Property> properties = propertyService.findAllPropertiesWithinRange(page, Double.parseDouble(request.getParameter("x")), Double.parseDouble(request.getParameter("y")));
        modelAndView.addObject("properties", properties);
        modelAndView.addObject("numberOfPages", properties.size() + 1);
        modelAndView.addObject("x", request.getParameter("x"));
        modelAndView.addObject("y", request.getParameter("y"));
        modelAndView.setViewName("rangeProperties");
        return modelAndView;
    }
}