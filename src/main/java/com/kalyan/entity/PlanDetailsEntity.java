package com.kalyan.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "eligibility_dtls")
public class PlanDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAN_ID")
	private Integer planId;
	@Column(name = "CASE_NUM")
	private Integer caseNumer;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	@Column(name = "HOLDER_NAME")
	private String holderName;
	@Column(name = "HOLDER_SSN")
	private Integer holderSsn;
	@Column(name = "BENEFIT_AMT")
	private Integer benefitAmount;
	@Column(name = "START_DATE")
	private LocalDate startDate;
	@Column(name = "END_DATE")
	private LocalDate endDate;
	@Column(name = "DENIAL_REASON")
	private String denialReason;

}
