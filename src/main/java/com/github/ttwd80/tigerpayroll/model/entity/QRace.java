package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRace is a Querydsl query type for Race
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRace extends EntityPathBase<Race> {

    private static final long serialVersionUID = 448224762L;

    public static final QRace race = new QRace("race");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final ComparablePath<Character> id = createComparable("id", Character.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final StringPath name = createString("name");

    public final SetPath<User, QUser> users = this.<User, QUser>createSet("users", User.class, QUser.class, PathInits.DIRECT2);

    public QRace(String variable) {
        super(Race.class, forVariable(variable));
    }

    public QRace(Path<? extends Race> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRace(PathMetadata<?> metadata) {
        super(Race.class, metadata);
    }

}

