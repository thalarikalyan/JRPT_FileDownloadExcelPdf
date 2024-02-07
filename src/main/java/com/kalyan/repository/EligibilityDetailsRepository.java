package com.kalyan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kalyan.entity.PlanDetailsEntity;
import com.kalyan.response.PlanDetailsResponse;

public interface EligibilityDetailsRepository extends JpaRepository<PlanDetailsEntity, Integer> {

	@Query("SELECT DISTINCT(planName) from PlanDetailsEntity")
	public List<String> getAllPlanNames();

	@Query("SELECT DISTINCT(planStatus) from PlanDetailsEntity")
	public List<String> getAllPlanStatus();

	@Query("SELECT e  from PlanDetailsEntity e")
	public List<PlanDetailsResponse> findAllPlans();

}
