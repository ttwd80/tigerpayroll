package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBackPayType is a Querydsl query type for BackPayType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBackPayType extends EntityPathBase<BackPayType> {

    private static final long serialVersionUID = 1306619346L;

    public static final QBackPayType backPayType1 = new QBackPayType("backPayType1");

    public final SetPath<BackPay, QBackPay> backPays = this.<BackPay, QBackPay>createSet("backPays", BackPay.class, QBackPay.class, PathInits.DIRECT2);

    public final ComparablePath<Character> backPayType = createComparable("backPayType", Character.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final StringPath name = createString("name");

    public QBackPayType(String variable) {
        super(BackPayType.class, forVariable(variable));
    }

    public QBackPayType(Path<? extends BackPayType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBackPayType(PathMetadata<?> metadata) {
        super(BackPayType.class, metadata);
    }

}

