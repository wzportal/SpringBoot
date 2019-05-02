package com.wzportal.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

public class RestBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestBaseController.class);

    @ExceptionHandler(IOException.class)
    public String ioException(Exception e) {
        LOGGER.error("IO Error", e);
        return "io error";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        LOGGER.error("Error", e);
        return "error";
    }
}
