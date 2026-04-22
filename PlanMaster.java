package com.IES.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plan_master_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plan_id")
	private Integer planId;

	@NotBlank(message = "Plan name is mandatory")
	@Size(min = 3, max = 100, message = "Plan name must be between 3 and 100 characters")
	@Column(name = "plan_name", nullable = false)
	private String planName;

	@NotNull(message = "Plan start date is required")
	@Column(name = "plan_start_date")
	private LocalDate planStartDate;

	@NotNull(message = "Plan end date is required")
	@Column(name = "plan_end_date")
	private LocalDate planEndDate;

	@NotNull(message = "Plan status is required (Y or N)")
	@Enumerated(EnumType.STRING)
	@Column(name = "active_sw")
	private ActiveStatus activeSw;

	@Size(max = 255, message = "Comments cannot be more than 255 characters")
	@Column(name = "comments")
	private String comments;

	@Column(name = "created_date", updatable = false)
	private LocalDate createdDate;

	@Column(name = "updated_date")
	private LocalDate updatedDate;

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public ActiveStatus getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(ActiveStatus activeSw) {
		this.activeSw = activeSw;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

}
