package com.myschool.commons.dto.support;

import com.myschool.constants.ResponseCode;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponseStatus {
    private int id;
    private ResponseCode code;
    private String message;
    private HttpStatus httpStatus;
}
