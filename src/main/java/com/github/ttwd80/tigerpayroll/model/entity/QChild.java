package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QChild is a Querydsl query type for Child
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QChild extends EntityPathBase<Child> {

    private static final long serialVersionUID = 996427539L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChild child = new QChild("child");

    public final DatePath<java.util.Date> dateOfBirth = createDate("dateOfBirth", java.util.Date.class);

    public final StringPath fullName = createString("fullName");

    public final QGender gender;

    public final BooleanPath handicapped = createBoolean("handicapped");

    public final StringPath icNo = createString("icNo");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath student = createBoolean("student");

    public final QUser user;

    public final BooleanPath working = createBoolean("working");

    public QChild(String variable) {
        this(Child.class, forVariable(variable), INITS);
    }

    public QChild(Path<? extends Child> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QChild(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QChild(PathMetadata<?> metadata, PathInits inits) {
        this(Child.class, metadata, inits);
    }

    public QChild(Class<? extends Child> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gender = inits.isInitialized("gender") ? new QGender(forProperty("gender")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

