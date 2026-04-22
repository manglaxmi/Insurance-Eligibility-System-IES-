package com.IES.service;

import java.util.List;
import com.IES.dto.CitizenApp;

public interface CitizenApplicationService {

    public boolean createApplication(CitizenApp citizenApp);

    public CitizenApp getApp(Integer appNum);

    public List<CitizenApp> getApps();

    public CitizenApp getAppWithCitizenId(Integer citizenId);
}