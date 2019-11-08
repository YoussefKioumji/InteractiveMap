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
        return new ModelAndView("home");
    }

    @RequestMapping("showRange")
    public ModelAndView showRangePage() {
        return new ModelAndView("rangePage");
    }

    @GetMapping(value = "/properties/page={page}")
    public ModelAndView showAllProperties(@PathVariable int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("properties", propertyService.findAllProperties(page));
        modelAndView.addObject("numberOfPages", propertyService.numberOfRows());
        modelAndView.setViewName("allProperties");
        return modelAndView;
    }

    @GetMapping(value = "/range/page={page}")
    public ModelAndView showAllPropertiesWithinRange(@PathVariable int page, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        List<Property> properties = propertyService.findAllPropertiesWithinRange(page, Double.parseDouble(x), Double.parseDouble(y));
        modelAndView.addObject("properties", properties);
        modelAndView.addObject("numberOfPages", properties.size() + 1);
        modelAndView.addObject("x", x);
        modelAndView.addObject("y", y);
        modelAndView.setViewName("rangeProperties");
        return modelAndView;
    }
}