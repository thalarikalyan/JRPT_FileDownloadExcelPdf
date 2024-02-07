package com.kalyan.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PlanRequestVO {

	private String planName;
	private String planStatus;
	private LocalDate startDate;
	private LocalDate endDate;

}
