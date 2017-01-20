package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;

/**
 * QUserRole is a Querydsl query type for UserRole
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserRole extends EntityPathBase<UserRole> {

	private static final long serialVersionUID = 127883658L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QUserRole userRole = new QUserRole("userRole");

	public final StringPath createdBy = createString("createdBy");

	public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

	public final NumberPath<Integer> id = createNumber("id", Integer.class);

	public final DateTimePath<java.util.Date> lastModifiedDate = createDateTime("lastModifiedDate",
			java.util.Date.class);

	public final QRole role;

	public final QUser userByLastModifiedBy;

	public final QUser userByUsername;

	public QUserRole(String variable) {
		this(UserRole.class, forVariable(variable), INITS);
	}

	public QUserRole(Path<? extends UserRole> path) {
		this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
	}

	public QUserRole(PathMetadata<?> metadata) {
		this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
	}

	public QUserRole(PathMetadata<?> metadata, PathInits inits) {
		this(UserRole.class, metadata, inits);
	}

	public QUserRole(Class<? extends UserRole> type, PathMetadata<?> metadata, PathInits inits) {
		super(type, metadata, inits);
		this.role = inits.isInitialized("role") ? new QRole(forProperty("role"), inits.get("role")) : null;
		this.userByLastModifiedBy = inits.isInitialized("userByLastModifiedBy")
				? new QUser(forProperty("userByLastModifiedBy"), inits.get("userByLastModifiedBy")) : null;
		this.userByUsername = inits.isInitialized("userByUsername")
				? new QUser(forProperty("userByUsername"), inits.get("userByUsername")) : null;
	}

}
