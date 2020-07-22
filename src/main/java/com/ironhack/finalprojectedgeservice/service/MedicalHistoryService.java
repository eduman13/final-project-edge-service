package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.PatientClient;
import com.ironhack.finalprojectedgeservice.model.dto.FamilyBackgroundDTO;
import com.ironhack.finalprojectedgeservice.model.dto.PatientDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalHistoryService {

    @Autowired
    PatientClient patientClient;

    public ByteArrayInputStream createPDF(Long patientId) throws Exception {
        PatientDTO patient = patientClient.findById(patientId);
        FamilyBackgroundDTO familyBackgroundDTO = patientClient.getFamilyBackgroundById(patientId);
        String medicalHistoryInfo = patientClient.findMedicalHistoryByPatient(patientId);

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        PDDocumentInformation pdd = document.getDocumentInformation();
        document.addPage(page);
        String surnames = patient.getSurnames().replace(" ", "_");
        StringBuffer buffer = new StringBuffer();
            buffer.append(patient.getName());
            buffer.append("_");
            buffer.append(surnames);
            buffer.append("_Medical_History");
        pdd.setTitle(buffer.toString());

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        int maxPerLine = 77;
        int spaceLines = 15;

        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
        contentStream.newLineAtOffset(25, 750);
        contentStream.setLeading(spaceLines);
        contentStream.showText("Family Background");
        contentStream.setFont(PDType1Font.COURIER, 12);
        List<String> lines = splitStringInLines(familyBackgroundDTO.getInformation(), maxPerLine);
        lines.forEach(s -> {
            try {
                contentStream.newLine();
                contentStream.showText(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
        contentStream.setLeading(spaceLines * 2);
        contentStream.newLine();
        contentStream.showText("Medical History");
        contentStream.setLeading(spaceLines);
        contentStream.setFont(PDType1Font.COURIER, 12);
        List<String> medicalHistoryInfoLines = splitStringInLines(medicalHistoryInfo, maxPerLine);
        medicalHistoryInfoLines.forEach(s -> {
            try {
                contentStream.newLine();
                contentStream.showText(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        contentStream.newLine();
        contentStream.endText();
        contentStream.close();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.save(byteArrayOutputStream);
        document.close();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    private List<String> splitStringInLines(String info, int size) {
        int sizeString = info.length();
        double number = (int) Math.ceil((double) sizeString / (double) size);
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String newString = info.substring(size * i, (size * (i + 1) > sizeString) ? sizeString : size * (i + 1));
            lines.add(newString.trim());
        }
        return lines;
    }
}
