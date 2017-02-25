package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QGender is a Querydsl query type for Gender
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QGender extends EntityPathBase<Gender> {

    private static final long serialVersionUID = 936370090L;

    public static final QGender gender = new QGender("gender");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final ComparablePath<Character> id = createComparable("id", Character.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final StringPath name = createString("name");

    public final SetPath<User, QUser> users = this.<User, QUser>createSet("users", User.class, QUser.class, PathInits.DIRECT2);

    public QGender(String variable) {
        super(Gender.class, forVariable(variable));
    }

    public QGender(Path<? extends Gender> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGender(PathMetadata<?> metadata) {
        super(Gender.class, metadata);
    }

}

