package com.IES.service;

import java.util.List;
import com.IES.dto.PlanDto;

public interface PlanService {

    public boolean savePlan(PlanDto planDto);

    public List<PlanDto> getPlans();

    public PlanDto getPlan(Integer planId);

    public boolean updatePlan(Integer planId, PlanDto planDto);
}