package com.IES.service.IMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.IES.dto.EducationDto;
import com.IES.dto.IncomeDto;
import com.IES.dto.KidsDto;
import com.IES.dto.Summary;
import com.IES.entity.CitizenApplication;
import com.IES.entity.DcEducation;
import com.IES.entity.DcIncome;
import com.IES.entity.DcKid;
import com.IES.repository.CitizenApplicationRepository;
import com.IES.repository.DcEducationRepository;
import com.IES.repository.DcIncomeRepository;
import com.IES.repository.DcKidRepository;
import com.IES.service.DataCollectionService;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {

    private final DcIncomeRepository incomeRepo;
    private final DcEducationRepository eduRepo;
    private final DcKidRepository kidRepo;
    private final CitizenApplicationRepository appRepo;

    public DataCollectionServiceImpl(DcIncomeRepository incomeRepo,
                                     DcEducationRepository eduRepo,
                                     DcKidRepository kidRepo,
                                     CitizenApplicationRepository appRepo) {
        this.incomeRepo = incomeRepo;
        this.eduRepo = eduRepo;
        this.kidRepo = kidRepo;
        this.appRepo = appRepo;
    }

    @Override
    public boolean saveIncome(IncomeDto dto, Integer appNum, Integer userId) {

        CitizenApplication app = appRepo.findById(appNum).orElseThrow();

        DcIncome income = new DcIncome();
        income.setSalaryIncome(dto.getSalaryIncome());
        income.setPropertyIncome(dto.getPropertyIncome());
        income.setCitizenApplication(app);

        incomeRepo.save(income);
        return true;
    }

    @Override
    public boolean saveEducation(EducationDto dto, Integer appNum, Integer userId) {

        CitizenApplication app = appRepo.findById(appNum).orElseThrow();

        DcEducation edu = new DcEducation();
        edu.setHighestDegree(dto.getHighestDegree());
        edu.setGradYear(dto.getGradYear());
        edu.setUniName(dto.getUniName());
        edu.setCitizenApplication(app);

        eduRepo.save(edu);
        return true;
    }

    @Override
    public boolean saveKids(KidsDto dto, Integer appNum, Integer userId) {

        CitizenApplication app = appRepo.findById(appNum).orElseThrow();

        DcKid kid = new DcKid();
        kid.setKidName(dto.getKidName());
        kid.setKidDob(dto.getKidDob());
        kid.setKidSsn(dto.getKidSsn());
        kid.setCitizenApplication(app);

        kidRepo.save(kid);
        return true;
    }

    @Override
    public Summary getSummaryData(Integer appNum) {

        Summary summary = new Summary();

        DcIncome income = incomeRepo.findByCitizenApplication_AppNumber(appNum);
        DcEducation edu = eduRepo.findByCitizenApplication_AppNumber(appNum);
        List<DcKid> kids = kidRepo.findByCitizenApplication_AppNumber(appNum);

        if (income != null) {
            IncomeDto incomeDto = new IncomeDto();
            incomeDto.setSalaryIncome(income.getSalaryIncome());
            incomeDto.setPropertyIncome(income.getPropertyIncome());
            summary.setIncome(incomeDto);
        }

        if (edu != null) {
            EducationDto eduDto = new EducationDto();
            eduDto.setHighestDegree(edu.getHighestDegree());
            eduDto.setGradYear(edu.getGradYear());
            eduDto.setUniName(edu.getUniName());
            summary.setEducation(eduDto);
        }

        List<KidsDto> kidDtos = kids.stream().map(k -> {
            KidsDto kd = new KidsDto();
            kd.setKidName(k.getKidName());
            kd.setKidDob(k.getKidDob());
            kd.setKidSsn(k.getKidSsn());
            return kd;
        }).collect(Collectors.toList());

        summary.setKids(kidDtos);

        return summary;
    }
}