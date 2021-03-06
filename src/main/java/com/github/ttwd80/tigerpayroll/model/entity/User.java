package com.github.ttwd80.tigerpayroll.model.entity;


import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,schema="public"
)
public class User  implements java.io.Serializable {


     private String username;
     private ChildSupportPercetage childSupportPercetageByChildSupportD;
     private ChildSupportPercetage childSupportPercetageByChildSupportC;
     private ChildSupportPercetage childSupportPercetageByChildSupportB;
     private ChildSupportPercetage childSupportPercetageByChildSupportA;
     private ChildSupportPercetage childSupportPercetageByChildSupportE;
     private Department department;
     private Gender gender;
     private Image image;
     private MaritalStatus maritalStatus;
     private Race race;
     private SocsoStatus socsoStatus;
     private String fullName;
     private String password;
     private boolean locked;
     private String address;
     private String phoneHandphone;
     private String phoneOffice;
     private Date dateOfBirth;
     private Date dateJoined;
     private String jobTitle;
     private String qualificationAcademic;
     private String qualificationProfessional;
     private String socsoNo;
     private String epfNo;
     private String incomeTaxNo;
     private BigDecimal basicSalary;
     private String bankAccountName;
     private String bankAccountNumber;
     private String bankBranchName;
     private String oldIc;
     private String newIc;
     private String icColour;
     private String passportNo;
     private String workPermitNo;
     private String nameAddressPreviousEmployer;
     private String spouseName;
     private String spouseSpouseOldIc;
     private String spouseSpouseNewIc;
     private String spouseDateOfBirth;
     private String spousePhoneHandphone;
     private String spousePhoneOffice;
     private Boolean spouseWorking;
     private String spouseIncomeTaxNo;
     private Date spouseAddress;
     private String createdBy;
     private ZonedDateTime createdDate;
     private String lastModifiedBy;
     private ZonedDateTime lastModifiedDate;
     private Set<BackPay> backPays = new HashSet<BackPay>(0);
     private Set<Role> rolesForLastModifiedBy = new HashSet<Role>(0);
     private Set<UserRole> userRolesForLastModifiedBy = new HashSet<UserRole>(0);
     private Set<UserRole> userRolesForUsername = new HashSet<UserRole>(0);
     private Set<Allowance> allowancesForLastModifiedBy = new HashSet<Allowance>(0);
     private Set<UserAllowance> userAllowancesForUsername = new HashSet<UserAllowance>(0);
     private Set<Child> childs = new HashSet<Child>(0);
     private Set<UserAllowance> userAllowancesForCreatedBy = new HashSet<UserAllowance>(0);
     private Set<Allowance> allowancesForCreatedBy = new HashSet<Allowance>(0);
     private Set<Role> rolesForCreatedBy = new HashSet<Role>(0);

    public User() {
    }

	
    public User(String username, Gender gender, String fullName, String password, boolean locked, BigDecimal basicSalary, String bankAccountName, String bankAccountNumber) {
        this.username = username;
        this.gender = gender;
        this.fullName = fullName;
        this.password = password;
        this.locked = locked;
        this.basicSalary = basicSalary;
        this.bankAccountName = bankAccountName;
        this.bankAccountNumber = bankAccountNumber;
    }
    public User(String username, ChildSupportPercetage childSupportPercetageByChildSupportD, ChildSupportPercetage childSupportPercetageByChildSupportC, ChildSupportPercetage childSupportPercetageByChildSupportB, ChildSupportPercetage childSupportPercetageByChildSupportA, ChildSupportPercetage childSupportPercetageByChildSupportE, Department department, Gender gender, Image image, MaritalStatus maritalStatus, Race race, SocsoStatus socsoStatus, String fullName, String password, boolean locked, String address, String phoneHandphone, String phoneOffice, Date dateOfBirth, Date dateJoined, String jobTitle, String qualificationAcademic, String qualificationProfessional, String socsoNo, String epfNo, String incomeTaxNo, BigDecimal basicSalary, String bankAccountName, String bankAccountNumber, String bankBranchName, String oldIc, String newIc, String icColour, String passportNo, String workPermitNo, String nameAddressPreviousEmployer, String spouseName, String spouseSpouseOldIc, String spouseSpouseNewIc, String spouseDateOfBirth, String spousePhoneHandphone, String spousePhoneOffice, Boolean spouseWorking, String spouseIncomeTaxNo, Date spouseAddress, String createdBy, ZonedDateTime createdDate, String lastModifiedBy, ZonedDateTime lastModifiedDate, Set<BackPay> backPays, Set<Role> rolesForLastModifiedBy, Set<UserRole> userRolesForLastModifiedBy, Set<UserRole> userRolesForUsername, Set<Allowance> allowancesForLastModifiedBy, Set<UserAllowance> userAllowancesForUsername, Set<Child> childs, Set<UserAllowance> userAllowancesForCreatedBy, Set<Allowance> allowancesForCreatedBy, Set<Role> rolesForCreatedBy) {
       this.username = username;
       this.childSupportPercetageByChildSupportD = childSupportPercetageByChildSupportD;
       this.childSupportPercetageByChildSupportC = childSupportPercetageByChildSupportC;
       this.childSupportPercetageByChildSupportB = childSupportPercetageByChildSupportB;
       this.childSupportPercetageByChildSupportA = childSupportPercetageByChildSupportA;
       this.childSupportPercetageByChildSupportE = childSupportPercetageByChildSupportE;
       this.department = department;
       this.gender = gender;
       this.image = image;
       this.maritalStatus = maritalStatus;
       this.race = race;
       this.socsoStatus = socsoStatus;
       this.fullName = fullName;
       this.password = password;
       this.locked = locked;
       this.address = address;
       this.phoneHandphone = phoneHandphone;
       this.phoneOffice = phoneOffice;
       this.dateOfBirth = dateOfBirth;
       this.dateJoined = dateJoined;
       this.jobTitle = jobTitle;
       this.qualificationAcademic = qualificationAcademic;
       this.qualificationProfessional = qualificationProfessional;
       this.socsoNo = socsoNo;
       this.epfNo = epfNo;
       this.incomeTaxNo = incomeTaxNo;
       this.basicSalary = basicSalary;
       this.bankAccountName = bankAccountName;
       this.bankAccountNumber = bankAccountNumber;
       this.bankBranchName = bankBranchName;
       this.oldIc = oldIc;
       this.newIc = newIc;
       this.icColour = icColour;
       this.passportNo = passportNo;
       this.workPermitNo = workPermitNo;
       this.nameAddressPreviousEmployer = nameAddressPreviousEmployer;
       this.spouseName = spouseName;
       this.spouseSpouseOldIc = spouseSpouseOldIc;
       this.spouseSpouseNewIc = spouseSpouseNewIc;
       this.spouseDateOfBirth = spouseDateOfBirth;
       this.spousePhoneHandphone = spousePhoneHandphone;
       this.spousePhoneOffice = spousePhoneOffice;
       this.spouseWorking = spouseWorking;
       this.spouseIncomeTaxNo = spouseIncomeTaxNo;
       this.spouseAddress = spouseAddress;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.lastModifiedBy = lastModifiedBy;
       this.lastModifiedDate = lastModifiedDate;
       this.backPays = backPays;
       this.rolesForLastModifiedBy = rolesForLastModifiedBy;
       this.userRolesForLastModifiedBy = userRolesForLastModifiedBy;
       this.userRolesForUsername = userRolesForUsername;
       this.allowancesForLastModifiedBy = allowancesForLastModifiedBy;
       this.userAllowancesForUsername = userAllowancesForUsername;
       this.childs = childs;
       this.userAllowancesForCreatedBy = userAllowancesForCreatedBy;
       this.allowancesForCreatedBy = allowancesForCreatedBy;
       this.rolesForCreatedBy = rolesForCreatedBy;
    }
   
     @Id 

    
    @Column(name="username", unique=true, nullable=false, length=20)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="child_support_d")
    public ChildSupportPercetage getChildSupportPercetageByChildSupportD() {
        return this.childSupportPercetageByChildSupportD;
    }
    
    public void setChildSupportPercetageByChildSupportD(ChildSupportPercetage childSupportPercetageByChildSupportD) {
        this.childSupportPercetageByChildSupportD = childSupportPercetageByChildSupportD;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="child_support_c")
    public ChildSupportPercetage getChildSupportPercetageByChildSupportC() {
        return this.childSupportPercetageByChildSupportC;
    }
    
    public void setChildSupportPercetageByChildSupportC(ChildSupportPercetage childSupportPercetageByChildSupportC) {
        this.childSupportPercetageByChildSupportC = childSupportPercetageByChildSupportC;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="child_support_b")
    public ChildSupportPercetage getChildSupportPercetageByChildSupportB() {
        return this.childSupportPercetageByChildSupportB;
    }
    
    public void setChildSupportPercetageByChildSupportB(ChildSupportPercetage childSupportPercetageByChildSupportB) {
        this.childSupportPercetageByChildSupportB = childSupportPercetageByChildSupportB;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="child_support_a")
    public ChildSupportPercetage getChildSupportPercetageByChildSupportA() {
        return this.childSupportPercetageByChildSupportA;
    }
    
    public void setChildSupportPercetageByChildSupportA(ChildSupportPercetage childSupportPercetageByChildSupportA) {
        this.childSupportPercetageByChildSupportA = childSupportPercetageByChildSupportA;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="child_support_e")
    public ChildSupportPercetage getChildSupportPercetageByChildSupportE() {
        return this.childSupportPercetageByChildSupportE;
    }
    
    public void setChildSupportPercetageByChildSupportE(ChildSupportPercetage childSupportPercetageByChildSupportE) {
        this.childSupportPercetageByChildSupportE = childSupportPercetageByChildSupportE;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id")
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gender_id", nullable=false)
    public Gender getGender() {
        return this.gender;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="image_id")
    public Image getImage() {
        return this.image;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="marital_status_id")
    public MaritalStatus getMaritalStatus() {
        return this.maritalStatus;
    }
    
    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="race_id")
    public Race getRace() {
        return this.race;
    }
    
    public void setRace(Race race) {
        this.race = race;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="socso_status_id")
    public SocsoStatus getSocsoStatus() {
        return this.socsoStatus;
    }
    
    public void setSocsoStatus(SocsoStatus socsoStatus) {
        this.socsoStatus = socsoStatus;
    }

    
    @Column(name="full_name", nullable=false, length=100)
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    @Column(name="password", nullable=false, length=60)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="locked", nullable=false)
    public boolean isLocked() {
        return this.locked;
    }
    
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    
    @Column(name="address")
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="phone_handphone", length=20)
    public String getPhoneHandphone() {
        return this.phoneHandphone;
    }
    
    public void setPhoneHandphone(String phoneHandphone) {
        this.phoneHandphone = phoneHandphone;
    }

    
    @Column(name="phone_office", length=20)
    public String getPhoneOffice() {
        return this.phoneOffice;
    }
    
    public void setPhoneOffice(String phoneOffice) {
        this.phoneOffice = phoneOffice;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_of_birth", length=13)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_joined", length=13)
    public Date getDateJoined() {
        return this.dateJoined;
    }
    
    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    
    @Column(name="job_title", length=100)
    public String getJobTitle() {
        return this.jobTitle;
    }
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    
    @Column(name="qualification_academic", length=100)
    public String getQualificationAcademic() {
        return this.qualificationAcademic;
    }
    
    public void setQualificationAcademic(String qualificationAcademic) {
        this.qualificationAcademic = qualificationAcademic;
    }

    
    @Column(name="qualification_professional", length=100)
    public String getQualificationProfessional() {
        return this.qualificationProfessional;
    }
    
    public void setQualificationProfessional(String qualificationProfessional) {
        this.qualificationProfessional = qualificationProfessional;
    }

    
    @Column(name="socso_no", length=20)
    public String getSocsoNo() {
        return this.socsoNo;
    }
    
    public void setSocsoNo(String socsoNo) {
        this.socsoNo = socsoNo;
    }

    
    @Column(name="epf_no", length=20)
    public String getEpfNo() {
        return this.epfNo;
    }
    
    public void setEpfNo(String epfNo) {
        this.epfNo = epfNo;
    }

    
    @Column(name="income_tax_no", length=20)
    public String getIncomeTaxNo() {
        return this.incomeTaxNo;
    }
    
    public void setIncomeTaxNo(String incomeTaxNo) {
        this.incomeTaxNo = incomeTaxNo;
    }

    
    @Column(name="basic_salary", nullable=false, precision=16)
    public BigDecimal getBasicSalary() {
        return this.basicSalary;
    }
    
    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    
    @Column(name="bank_account_name", nullable=false, length=100)
    public String getBankAccountName() {
        return this.bankAccountName;
    }
    
    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    
    @Column(name="bank_account_number", nullable=false, length=30)
    public String getBankAccountNumber() {
        return this.bankAccountNumber;
    }
    
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    
    @Column(name="bank_branch_name", length=100)
    public String getBankBranchName() {
        return this.bankBranchName;
    }
    
    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    
    @Column(name="old_ic", length=20)
    public String getOldIc() {
        return this.oldIc;
    }
    
    public void setOldIc(String oldIc) {
        this.oldIc = oldIc;
    }

    
    @Column(name="new_ic", length=20)
    public String getNewIc() {
        return this.newIc;
    }
    
    public void setNewIc(String newIc) {
        this.newIc = newIc;
    }

    
    @Column(name="ic_colour", length=25)
    public String getIcColour() {
        return this.icColour;
    }
    
    public void setIcColour(String icColour) {
        this.icColour = icColour;
    }

    
    @Column(name="passport_no", length=25)
    public String getPassportNo() {
        return this.passportNo;
    }
    
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    
    @Column(name="work_permit_no", length=25)
    public String getWorkPermitNo() {
        return this.workPermitNo;
    }
    
    public void setWorkPermitNo(String workPermitNo) {
        this.workPermitNo = workPermitNo;
    }

    
    @Column(name="name_address_previous_employer")
    public String getNameAddressPreviousEmployer() {
        return this.nameAddressPreviousEmployer;
    }
    
    public void setNameAddressPreviousEmployer(String nameAddressPreviousEmployer) {
        this.nameAddressPreviousEmployer = nameAddressPreviousEmployer;
    }

    
    @Column(name="spouse_name", length=100)
    public String getSpouseName() {
        return this.spouseName;
    }
    
    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    
    @Column(name="spouse_spouse_old_ic", length=20)
    public String getSpouseSpouseOldIc() {
        return this.spouseSpouseOldIc;
    }
    
    public void setSpouseSpouseOldIc(String spouseSpouseOldIc) {
        this.spouseSpouseOldIc = spouseSpouseOldIc;
    }

    
    @Column(name="spouse_spouse_new_ic", length=20)
    public String getSpouseSpouseNewIc() {
        return this.spouseSpouseNewIc;
    }
    
    public void setSpouseSpouseNewIc(String spouseSpouseNewIc) {
        this.spouseSpouseNewIc = spouseSpouseNewIc;
    }

    
    @Column(name="spouse_date_of_birth")
    public String getSpouseDateOfBirth() {
        return this.spouseDateOfBirth;
    }
    
    public void setSpouseDateOfBirth(String spouseDateOfBirth) {
        this.spouseDateOfBirth = spouseDateOfBirth;
    }

    
    @Column(name="spouse_phone_handphone", length=20)
    public String getSpousePhoneHandphone() {
        return this.spousePhoneHandphone;
    }
    
    public void setSpousePhoneHandphone(String spousePhoneHandphone) {
        this.spousePhoneHandphone = spousePhoneHandphone;
    }

    
    @Column(name="spouse_phone_office", length=20)
    public String getSpousePhoneOffice() {
        return this.spousePhoneOffice;
    }
    
    public void setSpousePhoneOffice(String spousePhoneOffice) {
        this.spousePhoneOffice = spousePhoneOffice;
    }

    
    @Column(name="spouse_working")
    public Boolean getSpouseWorking() {
        return this.spouseWorking;
    }
    
    public void setSpouseWorking(Boolean spouseWorking) {
        this.spouseWorking = spouseWorking;
    }

    
    @Column(name="spouse_income_tax_no", length=20)
    public String getSpouseIncomeTaxNo() {
        return this.spouseIncomeTaxNo;
    }
    
    public void setSpouseIncomeTaxNo(String spouseIncomeTaxNo) {
        this.spouseIncomeTaxNo = spouseIncomeTaxNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="spouse_address", length=13)
    public Date getSpouseAddress() {
        return this.spouseAddress;
    }
    
    public void setSpouseAddress(Date spouseAddress) {
        this.spouseAddress = spouseAddress;
    }

    
    @Column(name="created_by", length=20)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    
    @Column(name="created_date", length=35)
    @org.springframework.data.annotation.CreatedDate
    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    
    @Column(name="last_modified_by", length=20)
    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }
    
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    
    @Column(name="last_modified_date", length=35)
    @org.springframework.data.annotation.LastModifiedDate
    public ZonedDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }
    
    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<BackPay> getBackPays() {
        return this.backPays;
    }
    
    public void setBackPays(Set<BackPay> backPays) {
        this.backPays = backPays;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userByLastModifiedBy")
    public Set<Role> getRolesForLastModifiedBy() {
        return this.rolesForLastModifiedBy;
    }
    
    public void setRolesForLastModifiedBy(Set<Role> rolesForLastModifiedBy) {
        this.rolesForLastModifiedBy = rolesForLastModifiedBy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userByLastModifiedBy")
    public Set<UserRole> getUserRolesForLastModifiedBy() {
        return this.userRolesForLastModifiedBy;
    }
    
    public void setUserRolesForLastModifiedBy(Set<UserRole> userRolesForLastModifiedBy) {
        this.userRolesForLastModifiedBy = userRolesForLastModifiedBy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userByUsername")
    public Set<UserRole> getUserRolesForUsername() {
        return this.userRolesForUsername;
    }
    
    public void setUserRolesForUsername(Set<UserRole> userRolesForUsername) {
        this.userRolesForUsername = userRolesForUsername;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userByLastModifiedBy")
    public Set<Allowance> getAllowancesForLastModifiedBy() {
        return this.allowancesForLastModifiedBy;
    }
    
    public void setAllowancesForLastModifiedBy(Set<Allowance> allowancesForLastModifiedBy) {
        this.allowancesForLastModifiedBy = allowancesForLastModifiedBy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userByUsername")
    public Set<UserAllowance> getUserAllowancesForUsername() {
        return this.userAllowancesForUsername;
    }
    
    public void setUserAllowancesForUsername(Set<UserAllowance> userAllowancesForUsername) {
        this.userAllowancesForUsername = userAllowancesForUsername;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Child> getChilds() {
        return this.childs;
    }
    
    public void setChilds(Set<Child> childs) {
        this.childs = childs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userByCreatedBy")
    public Set<UserAllowance> getUserAllowancesForCreatedBy() {
        return this.userAllowancesForCreatedBy;
    }
    
    public void setUserAllowancesForCreatedBy(Set<UserAllowance> userAllowancesForCreatedBy) {
        this.userAllowancesForCreatedBy = userAllowancesForCreatedBy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userByCreatedBy")
    public Set<Allowance> getAllowancesForCreatedBy() {
        return this.allowancesForCreatedBy;
    }
    
    public void setAllowancesForCreatedBy(Set<Allowance> allowancesForCreatedBy) {
        this.allowancesForCreatedBy = allowancesForCreatedBy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userByCreatedBy")
    public Set<Role> getRolesForCreatedBy() {
        return this.rolesForCreatedBy;
    }
    
    public void setRolesForCreatedBy(Set<Role> rolesForCreatedBy) {
        this.rolesForCreatedBy = rolesForCreatedBy;
    }




}


