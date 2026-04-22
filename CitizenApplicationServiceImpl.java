package com.IES.service.IMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.IES.dto.CitizenApp;
import com.IES.entity.CitizenApplication;
import com.IES.entity.User;
import com.IES.entity.PlanMaster;
import com.IES.repository.CitizenApplicationRepository;
import com.IES.repository.UserRepository;
import com.IES.repository.PlanRepository;
import com.IES.service.CitizenApplicationService;

@Service
public class CitizenApplicationServiceImpl implements CitizenApplicationService {

    private final CitizenApplicationRepository appRepo;
    private final UserRepository userRepo;
    private final PlanRepository planRepo;

   
    public CitizenApplicationServiceImpl(CitizenApplicationRepository appRepo,
                                         UserRepository userRepo,
                                         PlanRepository planRepo) {
        this.appRepo = appRepo;
        this.userRepo = userRepo;
        this.planRepo = planRepo;
    }

    @Override
    public boolean createApplication(CitizenApp dto) {

        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        PlanMaster plan = planRepo.findById(dto.getPlanId()).orElseThrow();

       
        CitizenApplication entity = new CitizenApplication();
        entity.setFullname(dto.getFullname());
        entity.setDob(dto.getDob());
        entity.setGender(dto.getGender());
        entity.setSsn(dto.getSsn());
        entity.setUser(user);
        entity.setPlan(plan);

        appRepo.save(entity);

        return true;
    }

    @Override
    public CitizenApp getApp(Integer appNum) {

        CitizenApplication entity = appRepo.findById(appNum).orElseThrow();

        return mapToDto(entity);
    }

    @Override
    public List<CitizenApp> getApps() {

        return appRepo.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CitizenApp getAppWithCitizenId(Integer citizenId) {

        CitizenApplication entity = appRepo.findByUser_UserId(citizenId);

        if (entity == null) {
            return null;
        }

        return mapToDto(entity);
    }

    
    private CitizenApp mapToDto(CitizenApplication entity) {

        CitizenApp dto = new CitizenApp();

        dto.setAppNumber(entity.getAppNumber());
        dto.setFullname(entity.getFullname());
        dto.setDob(entity.getDob());
        dto.setGender(entity.getGender());
        dto.setSsn(entity.getSsn());
        dto.setUserId(entity.getUser().getUserId());
        dto.setPlanId(entity.getPlan().getPlanId());

        return dto;
    }
}