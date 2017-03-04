package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QChildSupportPercetage is a Querydsl query type for ChildSupportPercetage
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QChildSupportPercetage extends EntityPathBase<ChildSupportPercetage> {

    private static final long serialVersionUID = 1310319854L;

    public static final QChildSupportPercetage childSupportPercetage = new QChildSupportPercetage("childSupportPercetage");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final SetPath<User, QUser> usersForChildSupportA = this.<User, QUser>createSet("usersForChildSupportA", User.class, QUser.class, PathInits.DIRECT2);

    public final SetPath<User, QUser> usersForChildSupportB = this.<User, QUser>createSet("usersForChildSupportB", User.class, QUser.class, PathInits.DIRECT2);

    public final SetPath<User, QUser> usersForChildSupportC = this.<User, QUser>createSet("usersForChildSupportC", User.class, QUser.class, PathInits.DIRECT2);

    public final SetPath<User, QUser> usersForChildSupportD = this.<User, QUser>createSet("usersForChildSupportD", User.class, QUser.class, PathInits.DIRECT2);

    public final SetPath<User, QUser> usersForChildSupportE = this.<User, QUser>createSet("usersForChildSupportE", User.class, QUser.class, PathInits.DIRECT2);

    public QChildSupportPercetage(String variable) {
        super(ChildSupportPercetage.class, forVariable(variable));
    }

    public QChildSupportPercetage(Path<? extends ChildSupportPercetage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChildSupportPercetage(PathMetadata<?> metadata) {
        super(ChildSupportPercetage.class, metadata);
    }

}

