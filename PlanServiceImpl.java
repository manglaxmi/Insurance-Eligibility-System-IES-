package com.IES.service.IMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.IES.dto.PlanDto;
import com.IES.entity.ActiveStatus;
import com.IES.entity.PlanMaster;
import com.IES.repository.PlanRepository;
import com.IES.service.PlanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

	private final PlanRepository planRepository;

	public PlanServiceImpl(PlanRepository planRepository) {
		this.planRepository = planRepository;
	}

	@Override
	public boolean savePlan(PlanDto dto) {

		PlanMaster entity = new PlanMaster();
		entity.setPlanName(dto.getPlanName());
		entity.setPlanStartDate(dto.getPlanStartDate());
		entity.setPlanEndDate(dto.getPlanEndDate());
		entity.setComments(dto.getComments());
		entity.setActiveSw(ActiveStatus.valueOf(dto.getActiveSw()));

		planRepository.save(entity);

		return true;
	}

	@Override
	public List<PlanDto> getPlans() {

		return planRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public PlanDto getPlan(Integer planId) {

		PlanMaster entity = planRepository.findById(planId).orElseThrow();

		return convertToDto(entity);
	}

	@Override
	public boolean updatePlan(Integer planId, PlanDto dto) {

		PlanMaster entity = planRepository.findById(planId).orElseThrow();

		entity.setPlanName(dto.getPlanName());
		entity.setPlanStartDate(dto.getPlanStartDate());
		entity.setPlanEndDate(dto.getPlanEndDate());
		entity.setComments(dto.getComments());
		entity.setActiveSw(ActiveStatus.valueOf(dto.getActiveSw()));

		planRepository.save(entity);

		return true;
	}

	private PlanDto convertToDto(PlanMaster entity) {

		PlanDto dto = new PlanDto();
		dto.setPlanId(entity.getPlanId());
		dto.setPlanName(entity.getPlanName());
		dto.setPlanStartDate(entity.getPlanStartDate());
		dto.setPlanEndDate(entity.getPlanEndDate());
		dto.setComments(entity.getComments());
		dto.setActiveSw(entity.getActiveSw().name());

		return dto;
	}
}