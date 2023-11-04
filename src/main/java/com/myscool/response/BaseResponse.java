package com.myscool.response;

import com.myscool.response.support.Status;
import lombok.Data;

@Data
public class BaseResponse {
    private Status status;
}
