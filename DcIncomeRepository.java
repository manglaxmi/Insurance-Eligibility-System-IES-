package com.IES.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.IES.entity.DcIncome;

public interface DcIncomeRepository extends JpaRepository<DcIncome, Integer> {
    DcIncome findByCitizenApplication_AppNumber(Integer appNumber);
}