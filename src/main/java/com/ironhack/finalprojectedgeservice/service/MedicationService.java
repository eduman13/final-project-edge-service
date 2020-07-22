package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.PatientClient;
import com.ironhack.finalprojectedgeservice.model.dto.MedicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {

    @Autowired
    PatientClient patientClient;

    public MedicationDTO findByPatient(Long patientId) {
        return patientClient.findByPatient(patientId);
    }
}
