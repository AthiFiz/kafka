package com.fiz.product.error;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessage {

    private Date time;
    private String message;
    private String details;
}
