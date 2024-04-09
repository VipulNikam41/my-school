package com.myschool.commons.dto.support;

import lombok.Data;

@Data
public class BaseResponse {
    private ApiResponseStatus apiResponseStatus;
    private ApiResponseDescription apiResponseDescription;
}
