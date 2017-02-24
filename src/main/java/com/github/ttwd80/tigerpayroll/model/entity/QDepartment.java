package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDepartment is a Querydsl query type for Department
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDepartment extends EntityPathBase<Department> {

    private static final long serialVersionUID = 1926599611L;

    public static final QDepartment department = new QDepartment("department");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final StringPath name = createString("name");

    public QDepartment(String variable) {
        super(Department.class, forVariable(variable));
    }

    public QDepartment(Path<? extends Department> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartment(PathMetadata<?> metadata) {
        super(Department.class, metadata);
    }

}

