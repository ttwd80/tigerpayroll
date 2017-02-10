package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QImage is a Querydsl query type for Image
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QImage extends EntityPathBase<Image> {

    private static final long serialVersionUID = 1002109778L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QImage image1 = new QImage("image1");

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ArrayPath<byte[], Byte> image = createArray("image", byte[].class);

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final QUser userByCreatedBy;

    public final QUser userByLastModifiedBy;

    public final SetPath<User, QUser> users = this.<User, QUser>createSet("users", User.class, QUser.class, PathInits.DIRECT2);

    public QImage(String variable) {
        this(Image.class, forVariable(variable), INITS);
    }

    public QImage(Path<? extends Image> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QImage(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QImage(PathMetadata<?> metadata, PathInits inits) {
        this(Image.class, metadata, inits);
    }

    public QImage(Class<? extends Image> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userByCreatedBy = inits.isInitialized("userByCreatedBy") ? new QUser(forProperty("userByCreatedBy"), inits.get("userByCreatedBy")) : null;
        this.userByLastModifiedBy = inits.isInitialized("userByLastModifiedBy") ? new QUser(forProperty("userByLastModifiedBy"), inits.get("userByLastModifiedBy")) : null;
    }

}

