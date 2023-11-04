package com.myschool.response;

import com.myschool.response.support.Status;
import lombok.Data;

@Data
public class BaseResponse {
    private Status status;
}
