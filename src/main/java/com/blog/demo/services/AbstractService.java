package com.blog.demo.services;

import com.blog.demo.payloads.UserDto;

import java.util.List;

public interface AbstractService <T> {
    T create(UserDto userDto);
    T update(UserDto userDto, Integer id);
    T getById(Integer id);
    List<T> getAll();
    void delete(Integer id);
}
