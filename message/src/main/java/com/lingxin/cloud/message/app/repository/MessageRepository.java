package com.lingxin.cloud.message.app.repository;

import com.lingxin.cloud.app.message.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Mr_Li on 2016/8/30.
 */
public interface MessageRepository extends QueryDslPredicateExecutor<Message>, MongoRepository<Message, String> {
    @RestResource(path = "byNameLike", rel = "byNameLike")
    Message findByTitleContaining(@Param("title") String title);
}
