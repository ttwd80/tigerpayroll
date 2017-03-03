package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAllowance is a Querydsl query type for Allowance
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAllowance extends EntityPathBase<Allowance> {

    private static final long serialVersionUID = -285534577L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAllowance allowance = new QAllowance("allowance");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final ComparablePath<Character> id = createComparable("id", Character.class);

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> position = createNumber("position", Integer.class);

    public final SetPath<UserAllowance, QUserAllowance> userAllowances = this.<UserAllowance, QUserAllowance>createSet("userAllowances", UserAllowance.class, QUserAllowance.class, PathInits.DIRECT2);

    public final QUser userByCreatedBy;

    public final QUser userByLastModifiedBy;

    public QAllowance(String variable) {
        this(Allowance.class, forVariable(variable), INITS);
    }

    public QAllowance(Path<? extends Allowance> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAllowance(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAllowance(PathMetadata<?> metadata, PathInits inits) {
        this(Allowance.class, metadata, inits);
    }

    public QAllowance(Class<? extends Allowance> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userByCreatedBy = inits.isInitialized("userByCreatedBy") ? new QUser(forProperty("userByCreatedBy"), inits.get("userByCreatedBy")) : null;
        this.userByLastModifiedBy = inits.isInitialized("userByLastModifiedBy") ? new QUser(forProperty("userByLastModifiedBy"), inits.get("userByLastModifiedBy")) : null;
    }

}

