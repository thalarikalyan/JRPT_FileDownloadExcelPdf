package com.kalyan.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PlanDetailsResponse {

	private Integer planId;

	private Integer caseNumer;

	private String planName;

	private String planStatus;

	private String holderName;

	private Integer holderSsn;

	private Integer benefitAmount;

	private LocalDate startDate;

	private LocalDate endDate;

	private String denialReason;

}
