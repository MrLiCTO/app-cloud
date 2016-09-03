package com.lingxin.cloud.person.app.service;

import java.util.List;

/**
 * Created by Mr_Li on 2016/9/2.
 */
public interface BaseService<T> {
    void save(T t);

    void update(T t);

    void delete(String id);

    T findById(String id);

    List<T> findAll();
}
