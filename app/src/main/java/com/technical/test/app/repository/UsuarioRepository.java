package com.technical.test.app.repository;

import com.technical.test.app.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Integer> {

    List<Usuario> findByNombre(String nombre);
    List<Usuario> findByNombreContaining(String nombre);
}
