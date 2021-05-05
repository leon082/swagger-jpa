package com.technical.test.app.service.impl;

import com.technical.test.app.dto.Response;
import com.technical.test.app.model.Usuario;
import com.technical.test.app.repository.UsuarioRepository;
import com.technical.test.app.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static com.technical.test.app.utils.Constants.*;
import static com.technical.test.app.utils.Util.getErrorResponse;
import static com.technical.test.app.utils.Util.getOKResponse;
import static org.apache.logging.log4j.util.Strings.EMPTY;

@Service
public class UsuarioImpl implements IUsuario<Usuario> {

    @Autowired
    UsuarioRepository repository;


    @Override
    public Response getByName(String name) {
        Response response = new Response();
        try {
            List<Usuario> result = new ArrayList<>();
            if (name == null || name.equalsIgnoreCase(EMPTY)) {
                repository.findAll().forEach(i -> result.add(i));
                return getOKResponse(result, EMPTY);
            } else {
                repository.findByNombreContaining(name).forEach(i -> result.add(i));
                return getOKResponse(result, EMPTY);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return getErrorResponse(GENERIC_ERROR);
        }
    }

    @Override
    public Response save(Usuario user) {
        try {
            if (repository.findByNombre(user.getNombre()).size() > 0) {
                return getErrorResponse(SAVE_ERROR);
            } else {
                Usuario save = repository.save(user);
                return getOKResponse(save, EMPTY);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorResponse(GENERIC_ERROR);
        }

    }

    @Override
    public Response update(Usuario user) {
        try {
            Optional<Usuario> oldUser = repository.findById(user.getIdUsuario());
            if (!oldUser.isPresent()) {
                return getErrorResponse(UPDATE_ERROR);
            }
            user.setNombre(oldUser.get().getNombre());
            Usuario update = repository.save(user);
            return getOKResponse(update, EMPTY);
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorResponse(GENERIC_ERROR);
        }
    }

    @Override
    public Response delete(Integer id) {
        try{
            Optional<Usuario> user = repository.findById(id);
            if(!user.isPresent()){
                return getErrorResponse(UPDATE_ERROR);
            }
            repository.delete(user.get());
           return getOKResponse(user, "EMPTY");
        }catch(Exception e){
            e.printStackTrace();
            return getErrorResponse(GENERIC_ERROR);
        }
    }



}
