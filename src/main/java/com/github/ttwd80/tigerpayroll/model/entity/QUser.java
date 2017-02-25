package com.github.ttwd80.tigerpayroll.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 448331508L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final StringPath address = createString("address");

    public final NumberPath<Double> basicSalary = createNumber("basicSalary", Double.class);

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final DatePath<java.util.Date> dataJoined = createDate("dataJoined", java.util.Date.class);

    public final DatePath<java.util.Date> dataOfBirth = createDate("dataOfBirth", java.util.Date.class);

    public final QDepartment department;

    public final StringPath epfNo = createString("epfNo");

    public final StringPath fullName = createString("fullName");

    public final QGender gender;

    public final QImage image;

    public final SetPath<Image, QImage> imagesForCreatedBy = this.<Image, QImage>createSet("imagesForCreatedBy", Image.class, QImage.class, PathInits.DIRECT2);

    public final SetPath<Image, QImage> imagesForLastModifiedBy = this.<Image, QImage>createSet("imagesForLastModifiedBy", Image.class, QImage.class, PathInits.DIRECT2);

    public final StringPath incomeTaxNo = createString("incomeTaxNo");

    public final StringPath jobTitle = createString("jobTitle");

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final BooleanPath locked = createBoolean("locked");

    public final QMaritalStatus maritalStatus;

    public final StringPath password = createString("password");

    public final StringPath phoneCell = createString("phoneCell");

    public final StringPath phoneOffice = createString("phoneOffice");

    public final StringPath qualificationAcademic = createString("qualificationAcademic");

    public final StringPath qualificationProfessional = createString("qualificationProfessional");

    public final QRace race;

    public final SetPath<Role, QRole> rolesForCreatedBy = this.<Role, QRole>createSet("rolesForCreatedBy", Role.class, QRole.class, PathInits.DIRECT2);

    public final SetPath<Role, QRole> rolesForLastModifiedBy = this.<Role, QRole>createSet("rolesForLastModifiedBy", Role.class, QRole.class, PathInits.DIRECT2);

    public final StringPath socsoNo = createString("socsoNo");

    public final StringPath socsoStatus = createString("socsoStatus");

    public final QUser userByCreatedBy;

    public final QUser userByLastModifiedBy;

    public final StringPath username = createString("username");

    public final SetPath<UserRole, QUserRole> userRolesForLastModifiedBy = this.<UserRole, QUserRole>createSet("userRolesForLastModifiedBy", UserRole.class, QUserRole.class, PathInits.DIRECT2);

    public final SetPath<UserRole, QUserRole> userRolesForUsername = this.<UserRole, QUserRole>createSet("userRolesForUsername", UserRole.class, QUserRole.class, PathInits.DIRECT2);

    public final SetPath<User, QUser> usersForCreatedBy = this.<User, QUser>createSet("usersForCreatedBy", User.class, QUser.class, PathInits.DIRECT2);

    public final SetPath<User, QUser> usersForLastModifiedBy = this.<User, QUser>createSet("usersForLastModifiedBy", User.class, QUser.class, PathInits.DIRECT2);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department")) : null;
        this.gender = inits.isInitialized("gender") ? new QGender(forProperty("gender")) : null;
        this.image = inits.isInitialized("image") ? new QImage(forProperty("image"), inits.get("image")) : null;
        this.maritalStatus = inits.isInitialized("maritalStatus") ? new QMaritalStatus(forProperty("maritalStatus")) : null;
        this.race = inits.isInitialized("race") ? new QRace(forProperty("race")) : null;
        this.userByCreatedBy = inits.isInitialized("userByCreatedBy") ? new QUser(forProperty("userByCreatedBy"), inits.get("userByCreatedBy")) : null;
        this.userByLastModifiedBy = inits.isInitialized("userByLastModifiedBy") ? new QUser(forProperty("userByLastModifiedBy"), inits.get("userByLastModifiedBy")) : null;
    }

}

