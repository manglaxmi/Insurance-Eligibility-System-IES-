package com.IES.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phno")
    private Long phno;

    @Column(name = "pwd", nullable = false)
    private String pwd;

    @Column(name = "pwd_updated")
    private String pwdUpdated;

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    //@Override
    public String getEmail() {
        return email;
    }

   
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void setEmail(String email) { this.email = email; }

    public Long getPhno() { return phno; }
    public void setPhno(Long phno) { this.phno = phno; }

    public void setPwd(String pwd) { this.pwd = pwd; }

    public String getPwdUpdated() { return pwdUpdated; }
    public void setPwdUpdated(String pwdUpdated) { this.pwdUpdated = pwdUpdated; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public Date getCreatedDate() { return createdDate; }
    public Date getUpdatedDate() { return updatedDate; }
}