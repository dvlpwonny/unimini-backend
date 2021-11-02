package com.unimini.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResultUtil {

    private Object data;
    private HttpStatus status;
    private String message;

    public ResultUtil(Object data, HttpStatus status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

}
