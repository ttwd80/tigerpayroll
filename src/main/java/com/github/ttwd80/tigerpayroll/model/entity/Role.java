package com.github.ttwd80.tigerpayroll.model.entity;


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
 * Role generated by hbm2java
 */
@Entity
@Table(name="role"
    ,schema="public"
)
public class Role  implements java.io.Serializable {


     private String id;
     private User userByLastModifiedBy;
     private User userByCreatedBy;
     private Date createdDate;
     private Date lastModifiedDate;
     private Set<UserRole> userRoles = new HashSet<UserRole>(0);

    public Role() {
    }

	
    public Role(String id) {
        this.id = id;
    }
    public Role(String id, User userByLastModifiedBy, User userByCreatedBy, Date createdDate, Date lastModifiedDate, Set<UserRole> userRoles) {
       this.id = id;
       this.userByLastModifiedBy = userByLastModifiedBy;
       this.userByCreatedBy = userByCreatedBy;
       this.createdDate = createdDate;
       this.lastModifiedDate = lastModifiedDate;
       this.userRoles = userRoles;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=20)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="last_modified_by")
    public User getUserByLastModifiedBy() {
        return this.userByLastModifiedBy;
    }
    
    public void setUserByLastModifiedBy(User userByLastModifiedBy) {
        this.userByLastModifiedBy = userByLastModifiedBy;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="created_by")
    public User getUserByCreatedBy() {
        return this.userByCreatedBy;
    }
    
    public void setUserByCreatedBy(User userByCreatedBy) {
        this.userByCreatedBy = userByCreatedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date", length=35)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_modified_date", length=35)
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }
    
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }
    
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }




}

