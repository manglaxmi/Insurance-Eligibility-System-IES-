package com.IES.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "citizen_apps_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_number")
    private Integer appNumber;

    @NotBlank(message = "Fullname is required")
    @Size(min = 3, max = 100, message = "Fullname must be between 3 and 100 characters")
    @Column(name = "fullname", nullable = false, length = 100)
    private String fullname;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth must be in the past")
    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female or Other")
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @NotNull(message = "SSN is required")
    @Digits(integer = 9, fraction = 0, message = "SSN must be 9 digits")
    @Column(name = "ssn", nullable = false, unique = true)
    private Long ssn;

    // ==============================
    // Relationships
    // ==============================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User must be linked with application")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    @NotNull(message = "Plan must be selected for application")
    private PlanMaster plan;


    @Column(name = "created_date", updatable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;
    
    @PrePersist
    public void setCreatedDate() {
        this.createdDate = LocalDate.now();
    }

    @PreUpdate
    public void setUpdatedDate() {
        this.updatedDate = LocalDate.now();
    }

	public Integer getAppNumber() {
		return appNumber;
	}

	public void setAppNumber(Integer appNumber) {
		this.appNumber = appNumber;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PlanMaster getPlan() {
		return plan;
	}

	public void setPlan(PlanMaster plan) {
		this.plan = plan;
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
