package com.technical.test.app.service.impl;

import com.technical.test.app.dto.Response;
import com.technical.test.app.model.Rol;
import com.technical.test.app.repository.RolRepository;
import com.technical.test.app.service.IRol;

import static com.technical.test.app.utils.Constants.GENERIC_ERROR;
import static com.technical.test.app.utils.Util.getErrorResponse;
import static com.technical.test.app.utils.Util.getOKResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.logging.log4j.util.Strings.EMPTY;

import java.util.List;
@Service
public class RolImpl implements IRol {

    @Autowired
    RolRepository repository;

    @Override
    public Response getAll() {
        try {
            List<Rol> result = (List<Rol>) repository.findAll();
            return getOKResponse(result,EMPTY);
        }catch(Exception e){
            e.printStackTrace();
            return getErrorResponse(GENERIC_ERROR);
        }
    }
}
