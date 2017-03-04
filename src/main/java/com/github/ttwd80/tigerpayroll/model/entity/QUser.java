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

    public final SetPath<Allowance, QAllowance> allowancesForCreatedBy = this.<Allowance, QAllowance>createSet("allowancesForCreatedBy", Allowance.class, QAllowance.class, PathInits.DIRECT2);

    public final SetPath<Allowance, QAllowance> allowancesForLastModifiedBy = this.<Allowance, QAllowance>createSet("allowancesForLastModifiedBy", Allowance.class, QAllowance.class, PathInits.DIRECT2);

    public final StringPath bankAccountName = createString("bankAccountName");

    public final StringPath bankAccountNumber = createString("bankAccountNumber");

    public final StringPath bankBranchName = createString("bankBranchName");

    public final NumberPath<java.math.BigDecimal> basicSalary = createNumber("basicSalary", java.math.BigDecimal.class);

    public final SetPath<Child, QChild> childs = this.<Child, QChild>createSet("childs", Child.class, QChild.class, PathInits.DIRECT2);

    public final QChildSupportPercetage childSupportPercetageByChildSupportA;

    public final QChildSupportPercetage childSupportPercetageByChildSupportB;

    public final QChildSupportPercetage childSupportPercetageByChildSupportC;

    public final QChildSupportPercetage childSupportPercetageByChildSupportD;

    public final QChildSupportPercetage childSupportPercetageByChildSupportE;

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.ZonedDateTime> createdDate = createDateTime("createdDate", java.time.ZonedDateTime.class);

    public final DatePath<java.util.Date> dateJoined = createDate("dateJoined", java.util.Date.class);

    public final DatePath<java.util.Date> dateOfBirth = createDate("dateOfBirth", java.util.Date.class);

    public final QDepartment department;

    public final StringPath epfNo = createString("epfNo");

    public final StringPath fullName = createString("fullName");

    public final QGender gender;

    public final StringPath icColour = createString("icColour");

    public final QImage image;

    public final StringPath incomeTaxNo = createString("incomeTaxNo");

    public final StringPath jobTitle = createString("jobTitle");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.ZonedDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.ZonedDateTime.class);

    public final BooleanPath locked = createBoolean("locked");

    public final QMaritalStatus maritalStatus;

    public final StringPath nameAddressPreviousEmployer = createString("nameAddressPreviousEmployer");

    public final StringPath newIc = createString("newIc");

    public final StringPath oldIc = createString("oldIc");

    public final StringPath passportNo = createString("passportNo");

    public final StringPath password = createString("password");

    public final StringPath phoneHandphone = createString("phoneHandphone");

    public final StringPath phoneOffice = createString("phoneOffice");

    public final StringPath qualificationAcademic = createString("qualificationAcademic");

    public final StringPath qualificationProfessional = createString("qualificationProfessional");

    public final QRace race;

    public final SetPath<Role, QRole> rolesForCreatedBy = this.<Role, QRole>createSet("rolesForCreatedBy", Role.class, QRole.class, PathInits.DIRECT2);

    public final SetPath<Role, QRole> rolesForLastModifiedBy = this.<Role, QRole>createSet("rolesForLastModifiedBy", Role.class, QRole.class, PathInits.DIRECT2);

    public final StringPath socsoNo = createString("socsoNo");

    public final QSocsoStatus socsoStatus;

    public final DatePath<java.util.Date> spouseAddress = createDate("spouseAddress", java.util.Date.class);

    public final StringPath spouseDateOfBirth = createString("spouseDateOfBirth");

    public final StringPath spouseIncomeTaxNo = createString("spouseIncomeTaxNo");

    public final StringPath spouseName = createString("spouseName");

    public final StringPath spousePhoneHandphone = createString("spousePhoneHandphone");

    public final StringPath spousePhoneOffice = createString("spousePhoneOffice");

    public final StringPath spouseSpouseNewIc = createString("spouseSpouseNewIc");

    public final StringPath spouseSpouseOldIc = createString("spouseSpouseOldIc");

    public final BooleanPath spouseWorking = createBoolean("spouseWorking");

    public final SetPath<UserAllowance, QUserAllowance> userAllowancesForCreatedBy = this.<UserAllowance, QUserAllowance>createSet("userAllowancesForCreatedBy", UserAllowance.class, QUserAllowance.class, PathInits.DIRECT2);

    public final SetPath<UserAllowance, QUserAllowance> userAllowancesForUsername = this.<UserAllowance, QUserAllowance>createSet("userAllowancesForUsername", UserAllowance.class, QUserAllowance.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public final SetPath<UserRole, QUserRole> userRolesForLastModifiedBy = this.<UserRole, QUserRole>createSet("userRolesForLastModifiedBy", UserRole.class, QUserRole.class, PathInits.DIRECT2);

    public final SetPath<UserRole, QUserRole> userRolesForUsername = this.<UserRole, QUserRole>createSet("userRolesForUsername", UserRole.class, QUserRole.class, PathInits.DIRECT2);

    public final StringPath workPermitNo = createString("workPermitNo");

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
        this.childSupportPercetageByChildSupportA = inits.isInitialized("childSupportPercetageByChildSupportA") ? new QChildSupportPercetage(forProperty("childSupportPercetageByChildSupportA")) : null;
        this.childSupportPercetageByChildSupportB = inits.isInitialized("childSupportPercetageByChildSupportB") ? new QChildSupportPercetage(forProperty("childSupportPercetageByChildSupportB")) : null;
        this.childSupportPercetageByChildSupportC = inits.isInitialized("childSupportPercetageByChildSupportC") ? new QChildSupportPercetage(forProperty("childSupportPercetageByChildSupportC")) : null;
        this.childSupportPercetageByChildSupportD = inits.isInitialized("childSupportPercetageByChildSupportD") ? new QChildSupportPercetage(forProperty("childSupportPercetageByChildSupportD")) : null;
        this.childSupportPercetageByChildSupportE = inits.isInitialized("childSupportPercetageByChildSupportE") ? new QChildSupportPercetage(forProperty("childSupportPercetageByChildSupportE")) : null;
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department")) : null;
        this.gender = inits.isInitialized("gender") ? new QGender(forProperty("gender")) : null;
        this.image = inits.isInitialized("image") ? new QImage(forProperty("image")) : null;
        this.maritalStatus = inits.isInitialized("maritalStatus") ? new QMaritalStatus(forProperty("maritalStatus")) : null;
        this.race = inits.isInitialized("race") ? new QRace(forProperty("race")) : null;
        this.socsoStatus = inits.isInitialized("socsoStatus") ? new QSocsoStatus(forProperty("socsoStatus")) : null;
    }

}

