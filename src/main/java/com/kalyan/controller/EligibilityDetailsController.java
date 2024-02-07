package com.kalyan.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalyan.generator.PlanDetailsExcelGenerator;
import com.kalyan.generator.PlanDetailsPdfGenerator;
import com.kalyan.response.PlanDetailsResponse;
import com.kalyan.service.IEligibilityDetailsService;
import com.kalyan.vo.PlanRequestVO;

@RestController
@RequestMapping("/eligibility")
public class EligibilityDetailsController {

	@Autowired
	private IEligibilityDetailsService eligibilityDetailsService;

	@GetMapping("/loadAllPlanNames")
	public ResponseEntity<List<String>> getAllPlanNames() {
		List<String> loadAllPlanNames = eligibilityDetailsService.loadAllPlanNames();
		return new ResponseEntity<List<String>>(loadAllPlanNames, HttpStatus.OK);

	}

	@GetMapping("/loadAllPlanStatus")
	public ResponseEntity<List<String>> getAllPlanStatus() {
		List<String> loadAllPlanStatus = eligibilityDetailsService.loadAllPlanStatus();
		return new ResponseEntity<List<String>>(loadAllPlanStatus, HttpStatus.OK);

	}

	@PostMapping("/generateAllPlans")
	public ResponseEntity<List<PlanDetailsResponse>> getAllPlan(@RequestBody PlanRequestVO planRequestVO) {
		List<PlanDetailsResponse> getAllPlans = eligibilityDetailsService.getAllPlans(planRequestVO);
		return new ResponseEntity<List<PlanDetailsResponse>>(getAllPlans, HttpStatus.OK);

	}

	@PostMapping("/generateExcel")
	public ResponseEntity<byte[]> generateExcel(@RequestBody PlanRequestVO planRequestVO) throws IOException {

		List<PlanDetailsResponse> getAllPlans = eligibilityDetailsService.getAllPlans(planRequestVO);
		PlanDetailsExcelGenerator detailsExcelGenerator = new PlanDetailsExcelGenerator();
		byte[] generatePlasInExcel = detailsExcelGenerator.generatePlasInExcel(getAllPlans);
		// Set response headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "plans.xls");
		return ResponseEntity.ok().headers(headers).body(generatePlasInExcel);

	}

	@PostMapping("/generatePdf")
	public ResponseEntity<byte[]> generatePdf(@RequestBody PlanRequestVO planRequestVO) throws IOException {

		List<PlanDetailsResponse> getAllPlans = eligibilityDetailsService.getAllPlans(planRequestVO);
		PlanDetailsPdfGenerator detailsPdfGenerator = new PlanDetailsPdfGenerator();
		byte[] generatePlasInExcel = detailsPdfGenerator.generatePdf(getAllPlans);
		// Set response headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("attachment", "plans.pdf");
		return ResponseEntity.ok().headers(headers).body(generatePlasInExcel);

	}

}
