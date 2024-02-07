package com.kalyan.generator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import com.kalyan.response.PlanDetailsResponse;

@Component
public class PlanDetailsExcelGenerator {

	public byte[] generatePlasInExcel(List<PlanDetailsResponse> planDetailsResponse) throws IOException {
		// create WorkBook
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		// create Sheet
		HSSFSheet createSheet = hssfWorkbook.createSheet("plans");
		// createHeader
		HSSFRow headerRow = createSheet.createRow(0);
		// create cells for header
		headerRow.createCell(0).setCellValue("PlanId");
		headerRow.createCell(1).setCellValue("CaseNo");
		headerRow.createCell(2).setCellValue("PlanName");
		headerRow.createCell(3).setCellValue("PlanStatus");
		headerRow.createCell(4).setCellValue("HolderName");
		headerRow.createCell(5).setCellValue("HolderSSN");
		headerRow.createCell(6).setCellValue("BenefitAmount");
		headerRow.createCell(7).setCellValue("StartDate");
		headerRow.createCell(8).setCellValue("EndDate");
		headerRow.createCell(9).setCellValue("DenailReason");
		int i = 1;
		for (PlanDetailsResponse response : planDetailsResponse) {

			HSSFRow createRow = createSheet.createRow(i);
			createRow.createCell(0).setCellValue(response.getPlanId());
			createRow.createCell(1).setCellValue(response.getCaseNumer());
			createRow.createCell(2).setCellValue(response.getPlanName());
			createRow.createCell(3).setCellValue(response.getPlanStatus());
			createRow.createCell(4).setCellValue(response.getHolderName());
			createRow.createCell(5).setCellValue(response.getHolderSsn());
			createRow.createCell(6).setCellValue(response.getBenefitAmount());
			createRow.createCell(7).setCellValue(response.getStartDate());
			createRow.createCell(8).setCellValue(response.getEndDate());
			createRow.createCell(9).setCellValue(response.getDenialReason());
			i++;

		}
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		hssfWorkbook.write(stream);
		hssfWorkbook.close();
		return stream.toByteArray();
	}

}
