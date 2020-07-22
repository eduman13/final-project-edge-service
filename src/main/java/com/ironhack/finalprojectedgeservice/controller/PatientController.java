package com.ironhack.finalprojectedgeservice.controller;

import com.ironhack.finalprojectedgeservice.client.PatientClient;
import com.ironhack.finalprojectedgeservice.model.dto.MedicationDTO;
import com.ironhack.finalprojectedgeservice.model.dto.PatientDTO;
import com.ironhack.finalprojectedgeservice.service.MedicalHistoryService;
import com.ironhack.finalprojectedgeservice.service.MedicationService;
import com.ironhack.finalprojectedgeservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    PatientClient patientClient;

    @Autowired
    MedicalHistoryService medicalHistoryService;

    @Autowired
    MedicationService medicationService;

    @GetMapping("/patient/find_all_by_doctor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PatientDTO> findByDoctor(@PathVariable("id") Long doctorId) {
        return patientService.findByDoctor(doctorId);
    }

    @GetMapping("/patient/find_by_id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PatientDTO findById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @RequestMapping(value="/medical_history/pdf/{id}", method=RequestMethod.GET,
            produces=MediaType.APPLICATION_PDF_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<InputStreamResource> createPDF(@PathVariable("id") Long patientId) throws Exception {
        ByteArrayInputStream bis = medicalHistoryService.createPDF(patientId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=medicalHistory.pdf");
        return ResponseEntity
                .ok()
                .header(headers.toString())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping("/medication/find_by_patient/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicationDTO findByPatient(@PathVariable("id") Long patientId) {
        return medicationService.findByPatient(patientId);
    }
}
