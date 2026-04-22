package com.IES.service;

import com.IES.dto.*;

public interface DataCollectionService {

    public boolean saveIncome(IncomeDto income, Integer appNum, Integer userId);

    public boolean saveEducation(EducationDto education, Integer appNum, Integer userId);

    public boolean saveKids(KidsDto kidDto, Integer appNum, Integer userId);

    public Summary getSummaryData(Integer appNum);
}