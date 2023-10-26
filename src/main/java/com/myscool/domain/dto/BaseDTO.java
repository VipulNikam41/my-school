package com.myscool.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {
    private Date createdOn;
    private Date updatedOn;
}
