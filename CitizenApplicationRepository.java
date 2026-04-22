package com.IES.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.IES.entity.CitizenApplication;

public interface CitizenApplicationRepository 
        extends JpaRepository<CitizenApplication, Integer> {

    public CitizenApplication findByUser_UserId(Integer userId);
}