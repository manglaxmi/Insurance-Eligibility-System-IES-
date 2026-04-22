package com.IES.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "dc_edu_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DcEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private Integer eduId;

    @NotBlank
    @Column(name = "highest_degree", nullable = false)
    private String highestDegree;

    @NotNull
    @Column(name = "grad_year", nullable = false)
    private Integer gradYear;

    @NotBlank
    @Column(name = "uni_name", nullable = false)
    private String uniName;

    // Many educations belong to one CitizenApplication
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_number", nullable = false)
    private CitizenApplication citizenApplication;


	public Integer getEduId() {
		return eduId;
	}

	public void setEduId(Integer eduId) {
		this.eduId = eduId;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public Integer getGradYear() {
		return gradYear;
	}

	public void setGradYear(Integer gradYear) {
		this.gradYear = gradYear;
	}

	public String getUniName() {
		return uniName;
	}

	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	public CitizenApplication getCitizenApplication() {
		return citizenApplication;
	}

	public void setCitizenApplication(CitizenApplication citizenApplication) {
		this.citizenApplication = citizenApplication;
	}


}