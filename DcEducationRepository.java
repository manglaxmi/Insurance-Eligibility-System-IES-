package com.IES.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.IES.entity.DcEducation;

public interface DcEducationRepository extends JpaRepository<DcEducation, Integer> {
    DcEducation findByCitizenApplication_AppNumber(Integer appNumber);
}