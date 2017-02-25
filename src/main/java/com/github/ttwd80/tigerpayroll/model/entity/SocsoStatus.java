package com.github.ttwd80.tigerpayroll.model.entity;


import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SocsoStatus generated by hbm2java
 */
@Entity
@Table(name="socso_status"
    ,schema="public"
)
public class SocsoStatus  implements java.io.Serializable {


     private char id;
     private String label;
     private String note;
     private String createdBy;
     private String lastModifiedBy;
     private ZonedDateTime createdDate;
     private ZonedDateTime lastModifiedDate;
     private Set<User> users = new HashSet<User>(0);

    public SocsoStatus() {
    }

	
    public SocsoStatus(char id, String label) {
        this.id = id;
        this.label = label;
    }
    public SocsoStatus(char id, String label, String note, String createdBy, String lastModifiedBy, ZonedDateTime createdDate, ZonedDateTime lastModifiedDate, Set<User> users) {
       this.id = id;
       this.label = label;
       this.note = note;
       this.createdBy = createdBy;
       this.lastModifiedBy = lastModifiedBy;
       this.createdDate = createdDate;
       this.lastModifiedDate = lastModifiedDate;
       this.users = users;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=1)
    public char getId() {
        return this.id;
    }
    
    public void setId(char id) {
        this.id = id;
    }

    
    @Column(name="label", nullable=false, length=100)
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    
    @Column(name="note", length=100)
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }

    
    @Column(name="created_by", length=20)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    
    @Column(name="last_modified_by", length=20)
    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }
    
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    
    @Column(name="created_date", length=35)
    @org.springframework.data.annotation.CreatedDate
    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    
    @Column(name="last_modified_date", length=35)
    @org.springframework.data.annotation.LastModifiedDate
    public ZonedDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }
    
    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="socsoStatus")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}


