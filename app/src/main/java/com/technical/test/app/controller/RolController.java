package com.technical.test.app.controller;

import com.technical.test.app.dto.Response;
import com.technical.test.app.service.IRol;
import com.technical.test.app.utils.Constants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rol")
public class RolController {
    @Autowired
    private IRol service;

    @GetMapping
    @ApiOperation(value = "Gets all rols.", tags = { Constants.ROL_TAG})
    public Response getAll(){
        return service.getAll();
    }
}
