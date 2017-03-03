package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUserAllowance is a Querydsl query type for UserAllowance
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserAllowance extends EntityPathBase<UserAllowance> {

    private static final long serialVersionUID = -1238807676L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAllowance userAllowance = new QUserAllowance("userAllowance");

    public final QAllowance allowance;

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QUser userByCreatedBy;

    public final QUser userByUsername;

    public QUserAllowance(String variable) {
        this(UserAllowance.class, forVariable(variable), INITS);
    }

    public QUserAllowance(Path<? extends UserAllowance> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserAllowance(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserAllowance(PathMetadata<?> metadata, PathInits inits) {
        this(UserAllowance.class, metadata, inits);
    }

    public QUserAllowance(Class<? extends UserAllowance> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.allowance = inits.isInitialized("allowance") ? new QAllowance(forProperty("allowance"), inits.get("allowance")) : null;
        this.userByCreatedBy = inits.isInitialized("userByCreatedBy") ? new QUser(forProperty("userByCreatedBy"), inits.get("userByCreatedBy")) : null;
        this.userByUsername = inits.isInitialized("userByUsername") ? new QUser(forProperty("userByUsername"), inits.get("userByUsername")) : null;
    }

}

