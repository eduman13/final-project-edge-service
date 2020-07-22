package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.PatientClient;
import com.ironhack.finalprojectedgeservice.model.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientClient patientClient;

    public List<PatientDTO> findByDoctor(Long doctorId) {
        return patientClient.findAllByDoctorId(doctorId);
    }

    public PatientDTO findById(Long id) {
        return patientClient.findById(id);
    }
}
