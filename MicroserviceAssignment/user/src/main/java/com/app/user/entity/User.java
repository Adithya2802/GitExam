package com.app.user.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String name;
    private String mobile;
    private Date createdDate;
    private String createdBy;
    private Date lastModifiedDate;
    private String lastModifiedBy;

    public User() {
    }

    public User(String email, String name, String mobile, String createdBy, String lastModifiedBy) {
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

    public User(Long id, String email, String name, String mobile, String createdBy, String lastModifiedBy) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
