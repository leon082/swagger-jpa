package com.technical.test.app.controller;

import com.technical.test.app.dto.Response;
import com.technical.test.app.model.Usuario;
import com.technical.test.app.service.IUsuario;
import com.technical.test.app.utils.Constants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.apache.logging.log4j.util.Strings.EMPTY;


@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    @GetMapping
    @ApiOperation(value = "Gets all users", tags = { Constants.USER_TAG})
    public Response getAllUsers(){
        return usuarioService.getByName(EMPTY);
    }

    @GetMapping("/{name}")
    @ApiOperation(value = "Gets all users using name.", tags = { Constants.USER_TAG})
    @ApiImplicitParams(
            @ApiImplicitParam(required = false, value = "name", name = "name", paramType = "path", allowMultiple = false))
    public Response getUsersByName(@PathVariable String name){
        return usuarioService.getByName(name);
    }


    @PostMapping
    @ApiOperation(value = "Saves an user. you can't have two users with the same name.", tags = { Constants.USER_TAG})
    public Response loadUser(@RequestBody Usuario user){
        return usuarioService.save(user);
    }
    @PutMapping
    @ApiOperation(value = "Updates an user. You can't update the name value.", tags = { Constants.USER_TAG})
    public Response updateUser(@RequestBody Usuario user){
        return usuarioService.update(user);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes an users by id.", tags = { Constants.USER_TAG})
    @ApiImplicitParams(
            @ApiImplicitParam(required = false, value = "id user", name = "id", paramType = "path", allowMultiple = false))
    public Response deleteUser(@PathVariable Integer id){
        return usuarioService.delete(id);
    }
}
