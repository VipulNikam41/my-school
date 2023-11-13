package com.myschool.domain.dto;

import com.myschool.domain.dto.support.Status;
import lombok.Data;

@Data
public class BaseResponse {
    private Status status;
}
