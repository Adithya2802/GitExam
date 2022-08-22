package com.app.user.dto;

public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String mobile;
    private String createdBy;
    private String lastModifiedBy;

    public UserDto() {
    }

    public UserDto(Long id, String email, String name, String mobile, String createdBy, String lastModifiedBy) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
