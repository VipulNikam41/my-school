package com.myschool.commons.dto.support;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ApiResponseDescription {
    private String message;
    private List<String> additionalInfo;
    private Date date;
}
