package com.kalyan.service;

import java.util.List;

import com.kalyan.response.PlanDetailsResponse;
import com.kalyan.vo.PlanRequestVO;

public interface IEligibilityDetailsService {

	public List<String> loadAllPlanNames();

	public List<String> loadAllPlanStatus();

	public List<PlanDetailsResponse> getAllPlans(PlanRequestVO planRequestVO);

}
