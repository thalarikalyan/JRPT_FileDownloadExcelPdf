package com.kalyan.generator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;

import com.kalyan.response.PlanDetailsResponse;

@Component
public class PlanDetailsPdfGenerator {

	public byte[] generatePdf(List<PlanDetailsResponse> planDetailsResponse) throws IOException {
		PDDocument document = new PDDocument();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PDPage page = new PDPage();
		document.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
		contentStream.beginText();
		contentStream.newLineAtOffset(100, 700);

		for (PlanDetailsResponse plDetailsResponse : planDetailsResponse) {
			contentStream.showText("PlanId: " + plDetailsResponse.getPlanId());
			contentStream.newLineAtOffset(0, -20);
			contentStream.showText("PlanName: " + plDetailsResponse.getPlanName());
			contentStream.newLineAtOffset(0, -20);
			contentStream.showText("PlanStatus: " + plDetailsResponse.getPlanStatus());
			contentStream.newLineAtOffset(0, -20);
			contentStream.showText("HolderName: " + plDetailsResponse.getHolderName());
			contentStream.newLineAtOffset(0, -20);
			contentStream.showText("HolderSSN: " + plDetailsResponse.getHolderSsn());
			contentStream.newLineAtOffset(0, -20);
			contentStream.showText("BenefitAmount: " + plDetailsResponse.getBenefitAmount());
			contentStream.newLineAtOffset(0, -20);
			contentStream.showText("StartDate: " + plDetailsResponse.getStartDate());
			contentStream.newLineAtOffset(0, -20);
			contentStream.showText("EndDate: " + plDetailsResponse.getEndDate());
			contentStream.newLineAtOffset(0, -20);
			contentStream.showText("DenailReason: " + plDetailsResponse.getDenialReason());
			contentStream.newLineAtOffset(0, -20);


		}

		contentStream.endText();
		contentStream.close();

		document.save(outputStream);
		return outputStream.toByteArray();
	}
}
