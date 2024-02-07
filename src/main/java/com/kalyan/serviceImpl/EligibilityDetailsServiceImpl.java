package com.kalyan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.kalyan.entity.PlanDetailsEntity;
import com.kalyan.repository.EligibilityDetailsRepository;
import com.kalyan.response.PlanDetailsResponse;
import com.kalyan.service.IEligibilityDetailsService;
import com.kalyan.vo.PlanRequestVO;

@Service
public class EligibilityDetailsServiceImpl implements IEligibilityDetailsService {

	@Autowired
	private EligibilityDetailsRepository eligibilityDetailsRepository;

	@Override
	public List<String> loadAllPlanNames() {

		return eligibilityDetailsRepository.getAllPlanNames();
	}

	@Override
	public List<String> loadAllPlanStatus() {

		return eligibilityDetailsRepository.getAllPlanStatus();
	}

	@Override
	public List<PlanDetailsResponse> getAllPlans(PlanRequestVO planRequestVO) {

		List<PlanDetailsResponse> planDetailsResponses = new ArrayList<>();

		// if user won't select anything then display all the data from the table
		if (checkAllAttributeDetails(planRequestVO)) {
			List<PlanDetailsEntity> findAll = eligibilityDetailsRepository.findAll();
			for (PlanDetailsEntity planDetailsEntity : findAll) {

				PlanDetailsResponse planDetailsResponse = new PlanDetailsResponse();
				BeanUtils.copyProperties(planDetailsEntity, planDetailsResponse);
				planDetailsResponses.add(planDetailsResponse);
			}

		} else {

			PlanDetailsEntity detailsEntity = new PlanDetailsEntity();
			if (planRequestVO.getPlanName() != null && !planRequestVO.getPlanName().equals(""))
				detailsEntity.setPlanName(planRequestVO.getPlanName());
			if (planRequestVO.getPlanStatus() != null && !planRequestVO.getPlanName().equals(""))
				detailsEntity.setPlanStatus(planRequestVO.getPlanStatus());
			if (planRequestVO.getStartDate() != null)
				detailsEntity.setStartDate(planRequestVO.getStartDate());
			if (planRequestVO.getEndDate() != null)
				detailsEntity.setEndDate(planRequestVO.getEndDate());
			// generate dynamic queries based on the input values
			Example<PlanDetailsEntity> getRespecitveColumn = Example.of(detailsEntity);
			List<PlanDetailsEntity> findAllEligibilityPlans = eligibilityDetailsRepository.findAll(getRespecitveColumn);
			for (PlanDetailsEntity planDetailsEntity : findAllEligibilityPlans) {

				PlanDetailsResponse planDetailsResponse = new PlanDetailsResponse();
				BeanUtils.copyProperties(planDetailsEntity, planDetailsResponse);
				planDetailsResponses.add(planDetailsResponse);
			}

		}

		return planDetailsResponses;

	}

	private boolean checkAllAttributeDetails(PlanRequestVO planRequestVO) {
		if (planRequestVO == null)
			return true;

		if (planRequestVO.getPlanName() != null && !planRequestVO.getPlanName().equals(""))
			return false;
		if (planRequestVO.getPlanStatus() != null && !planRequestVO.getPlanName().equals(""))
			return false;
		if (planRequestVO.getStartDate() != null)
			return false;
		if (planRequestVO.getEndDate() != null)
			return false;
		return true;

	}

}
