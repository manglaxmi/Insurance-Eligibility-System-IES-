package com.IES.dto;

import java.util.List;

public class Summary {

    private IncomeDto income;
    private EducationDto education;
    private List<KidsDto> kids;
	public IncomeDto getIncome() {
		return income;
	}
	public void setIncome(IncomeDto income) {
		this.income = income;
	}
	public EducationDto getEducation() {
		return education;
	}
	public void setEducation(EducationDto education) {
		this.education = education;
	}
	public List<KidsDto> getKids() {
		return kids;
	}
	public void setKids(List<KidsDto> kids) {
		this.kids = kids;
	}


}