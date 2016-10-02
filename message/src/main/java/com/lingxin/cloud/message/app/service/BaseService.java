package com.lingxin.cloud.message.app.service;

import java.util.List;

/**
 * Created by Mr_Li on 2016/9/2.
 */
public interface BaseService<T> {
    T save(T t);

    T update(T t);

    void delete(String id);

    T findById(String id);

    List<T> findAll();
}
