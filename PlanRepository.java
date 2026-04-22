package com.IES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IES.entity.PlanMaster;

public interface PlanRepository extends JpaRepository<PlanMaster, Integer>  {

}
