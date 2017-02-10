package com.github.ttwd80.tigerpayroll.model.entity;


import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Image generated by hbm2java
 */
@Entity
@Table(name="image"
    ,schema="public"
)
public class Image  implements java.io.Serializable {


     private Integer id;
     private User userByCreatedBy;
     private User userByLastModifiedBy;
     private byte[] image;
     private ZonedDateTime createdDate;
     private ZonedDateTime lastModifiedDate;
     private Set<User> users = new HashSet<User>(0);

    public Image() {
    }

	
    public Image(byte[] image) {
        this.image = image;
    }
    public Image(User userByCreatedBy, User userByLastModifiedBy, byte[] image, ZonedDateTime createdDate, ZonedDateTime lastModifiedDate, Set<User> users) {
       this.userByCreatedBy = userByCreatedBy;
       this.userByLastModifiedBy = userByLastModifiedBy;
       this.image = image;
       this.createdDate = createdDate;
       this.lastModifiedDate = lastModifiedDate;
       this.users = users;
    }
   
     @GenericGenerator(name="generator", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator", parameters={@Parameter(name="optimizer", value="none"), @Parameter(name="sequence_name", value="image_id_seq"), @Parameter(name="increment_size", value="1")})@Id @GeneratedValue(generator="generator")

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="last_modified_by")
    @org.springframework.data.annotation.LastModifiedBy
    public User getUserByLastModifiedBy() {
        return this.userByLastModifiedBy;
    }
    
    public void setUserByLastModifiedBy(User userByLastModifiedBy) {
        this.userByLastModifiedBy = userByLastModifiedBy;
    }

    
    @Column(name="image", nullable=false)
    public byte[] getImage() {
        return this.image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="image")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}


