package com.IES.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dc_income_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DcIncome {

   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_id")
    private Integer incomeId;

    @Min(0)
    @Column(name = "salary_income", nullable = false)
    private Integer salaryIncome;

    @Min(0)
    @Column(name = "property_income", nullable = false)
    private Integer propertyIncome;

    // Many incomes belong to one CitizenApplication
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_number", nullable = false)
    private CitizenApplication citizenApplication;
    public Integer getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}

	public Integer getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Integer salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Integer getPropertyIncome() {
		return propertyIncome;
	}

	public void setPropertyIncome(Integer propertyIncome) {
		this.propertyIncome = propertyIncome;
	}

	public CitizenApplication getCitizenApplication() {
		return citizenApplication;
	}

	public void setCitizenApplication(CitizenApplication citizenApplication) {
		this.citizenApplication = citizenApplication;
	}

}