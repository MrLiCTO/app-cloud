package com.lingxin.cloud.message.app.repository;

import com.lingxin.cloud.message.app.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;

/**
 * Created by Mr_Li on 2016/8/30.
 */
public interface PersonRepository extends CrudRepository<Person, Serializable>, MongoRepository<Person, Serializable> {
    @RestResource(path = "byNameLike", rel = "byNameLike")
    Person findByNameContaining(@Param("name") String name);
}
