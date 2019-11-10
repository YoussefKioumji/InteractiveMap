package com.training.interactivemap.data.dto;

import java.util.List;

public class PropertyDto {
    private Integer id;
    private Integer rooms;
    private Double area;
    private String description;
    private String address;
    private Double xAxis;
    private Double yAxis;
    private List<PictureDto> pictures;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getxAxis() {
        return xAxis;
    }

    public void setxAxis(Double xAxis) {
        this.xAxis = xAxis;
    }

    public Double getyAxis() {
        return yAxis;
    }

    public void setyAxis(Double yAxis) {
        this.yAxis = yAxis;
    }

    public List<PictureDto> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureDto> pictures) {
        this.pictures = pictures;
    }
}