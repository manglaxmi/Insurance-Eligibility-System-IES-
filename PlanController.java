package com.IES.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.IES.dto.PlanDto;
import com.IES.service.PlanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public String savePlan(@RequestBody PlanDto dto) {
        planService.savePlan(dto);
        return "Plan saved successfully";
    }

    @GetMapping
    public List<PlanDto> getPlans() {
        return planService.getPlans();
    }

    @GetMapping("/{id}")
    public PlanDto getPlan(@PathVariable Integer id) {
        return planService.getPlan(id);
    }

    @PutMapping("/{id}")
    public String updatePlan(@PathVariable Integer id, @RequestBody PlanDto dto) {
        planService.updatePlan(id, dto);
        return "Plan updated successfully";
    }
}