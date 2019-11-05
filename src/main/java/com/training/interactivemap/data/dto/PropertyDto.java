package com.training.interactivemap.data.dto;

import java.math.BigDecimal;
import java.util.List;

public class PropertyDto {
    private Integer id;
    private Integer rooms;
    private BigDecimal area;
    private String description;
    private String address;
    private BigDecimal xAxis;
    private BigDecimal yAxis;
    private List<PictureDto> pictures;
}