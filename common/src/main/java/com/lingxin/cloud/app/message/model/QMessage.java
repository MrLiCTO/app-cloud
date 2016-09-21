package com.lingxin.cloud.app.message.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.StringPath;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QMessage is a Querydsl query type for Message
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMessage extends EntityPathBase<Message> {

    public static final QMessage message = new QMessage("message");
    private static final long serialVersionUID = -2063234303L;
    public final StringPath content = createString("content");

    public final StringPath id = createString("id");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public QMessage(String variable) {
        super(Message.class, forVariable(variable));
    }

    public QMessage(Path<? extends Message> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMessage(PathMetadata<?> metadata) {
        super(Message.class, metadata);
    }

}

