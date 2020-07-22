package com.ironhack.finalprojectedgeservice.client;

import com.ironhack.finalprojectedgeservice.model.dto.FamilyBackgroundDTO;
import com.ironhack.finalprojectedgeservice.model.dto.MedicationDTO;
import com.ironhack.finalprojectedgeservice.model.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="patient-service")
public interface PatientClient {

    @GetMapping("/patient/find_all_by_doctor/{id}")
    List<PatientDTO> findAllByDoctorId(@PathVariable("id") Long doctorId);

    @GetMapping("/patient/find_by_id/{id}")
    PatientDTO findById(@PathVariable Long id);

    @GetMapping("/medical_history/{id}")
    String findMedicalHistoryByPatient(@PathVariable("id") Long patientId);

    @GetMapping("/family_background/get_by_id/{id}")
    FamilyBackgroundDTO getFamilyBackgroundById(@PathVariable("id") Long patientId);

    @GetMapping("/medication/find_by_patient/{id}")
    MedicationDTO findByPatient(@PathVariable("id") Long patientId);

}
