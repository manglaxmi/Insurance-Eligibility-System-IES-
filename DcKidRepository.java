package com.IES.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IES.entity.DcKid;

public interface DcKidRepository extends JpaRepository<DcKid, Integer> {
	
    List<DcKid> findByCitizenApplication_AppNumber(Integer appNumber);
}