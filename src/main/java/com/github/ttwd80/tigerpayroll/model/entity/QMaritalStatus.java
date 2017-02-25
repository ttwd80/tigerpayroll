package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QMaritalStatus is a Querydsl query type for MaritalStatus
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMaritalStatus extends EntityPathBase<MaritalStatus> {

    private static final long serialVersionUID = -1818304259L;

    public static final QMaritalStatus maritalStatus = new QMaritalStatus("maritalStatus");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final ComparablePath<Character> id = createComparable("id", Character.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final StringPath name = createString("name");

    public final SetPath<User, QUser> users = this.<User, QUser>createSet("users", User.class, QUser.class, PathInits.DIRECT2);

    public QMaritalStatus(String variable) {
        super(MaritalStatus.class, forVariable(variable));
    }

    public QMaritalStatus(Path<? extends MaritalStatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaritalStatus(PathMetadata<?> metadata) {
        super(MaritalStatus.class, metadata);
    }

}

