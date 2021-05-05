package com.technical.test.app.utils;

import com.technical.test.app.dto.Response;
import org.springframework.http.HttpStatus;

import java.util.Collections;

public class Util {

    public static Response getErrorResponse(String message) {
        Response response = new Response();
        response.setData(Collections.emptyList());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(message);
        return response;
    }

    public static Response getOKResponse(Object data, String message) {
        Response response = new Response();
        response.setData(data);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(message);
        return response;
    }
}
