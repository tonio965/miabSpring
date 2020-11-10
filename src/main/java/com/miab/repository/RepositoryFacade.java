package com.miab.repository;

import java.util.List;

public interface RepositoryFacade {
    <T> void save(T obj);
    <T> List<T> findAll(Class<T> clazz);
    <T> T findById(Long id, Class<T> clazz);
    <T> T findByUsername(String username);
    void deleteByUsername(String username);
    void delete(Long id, Class clazz); 
}
