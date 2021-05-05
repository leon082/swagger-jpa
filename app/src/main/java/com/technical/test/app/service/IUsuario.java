package com.technical.test.app.service;

import com.technical.test.app.dto.Response;

public interface IUsuario<T> {
    public Response getByName(String name);
    public Response save(T obj);
    public Response update(T obj);
    public Response delete(Integer id);



}
