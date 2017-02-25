package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSocsoStatus is a Querydsl query type for SocsoStatus
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSocsoStatus extends EntityPathBase<SocsoStatus> {

    private static final long serialVersionUID = 467376300L;

    public static final QSocsoStatus socsoStatus = new QSocsoStatus("socsoStatus");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final ComparablePath<Character> id = createComparable("id", Character.class);

    public final StringPath label = createString("label");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final StringPath note = createString("note");

    public final SetPath<User, QUser> users = this.<User, QUser>createSet("users", User.class, QUser.class, PathInits.DIRECT2);

    public QSocsoStatus(String variable) {
        super(SocsoStatus.class, forVariable(variable));
    }

    public QSocsoStatus(Path<? extends SocsoStatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSocsoStatus(PathMetadata<?> metadata) {
        super(SocsoStatus.class, metadata);
    }

}

