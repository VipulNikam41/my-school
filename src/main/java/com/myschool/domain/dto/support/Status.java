package com.myschool.domain.dto.support;

import com.myschool.constants.ResponseCode;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class Status {
    private int id;
    private ResponseCode code;
    private String message;
    private HttpStatus httpStatus;
    private List<String> additionalInfo;
}
