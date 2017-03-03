package com.github.ttwd80.tigerpayroll.model.entity;


import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UserAllowance generated by hbm2java
 */
@Entity
@Table(name="user_allowance"
    ,schema="public"
    , uniqueConstraints = @UniqueConstraint(columnNames={"username", "allowance_id"}) 
)
public class UserAllowance  implements java.io.Serializable {


     private Integer id;
     private Allowance allowance;
     private User userByUsername;
     private User userByCreatedBy;
     private ZonedDateTime createdDate;

    public UserAllowance() {
    }

	
    public UserAllowance(Integer id, Allowance allowance, User userByUsername) {
        this.id = id;
        this.allowance = allowance;
        this.userByUsername = userByUsername;
    }
    public UserAllowance(Integer id, Allowance allowance, User userByUsername, User userByCreatedBy, ZonedDateTime createdDate) {
       this.id = id;
       this.allowance = allowance;
       this.userByUsername = userByUsername;
       this.userByCreatedBy = userByCreatedBy;
       this.createdDate = createdDate;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="allowance_id", nullable=false)
    public Allowance getAllowance() {
        return this.allowance;
    }
    
    public void setAllowance(Allowance allowance) {
        this.allowance = allowance;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username", nullable=false)
    public User getUserByUsername() {
        return this.userByUsername;
    }
    
    public void setUserByUsername(User userByUsername) {
        this.userByUsername = userByUsername;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="created_by")
    @org.springframework.data.annotation.CreatedBy
    public User getUserByCreatedBy() {
        return this.userByCreatedBy;
    }
    
    public void setUserByCreatedBy(User userByCreatedBy) {
        this.userByCreatedBy = userByCreatedBy;
    }

    
    @Column(name="created_date", length=35)
    @org.springframework.data.annotation.CreatedDate
    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }




}

