package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.PatientClient;
import com.ironhack.finalprojectedgeservice.model.dto.FamilyBackgroundDTO;
import com.ironhack.finalprojectedgeservice.model.dto.PatientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MedicalHistoryServiceTest {

    @Autowired
    MedicalHistoryService medicalHistoryService;

    @MockBean
    PatientClient patientClient;

    private PatientDTO patientDTO;
    private FamilyBackgroundDTO familyBackgroundDTO;
    private String medicalHistoryInfo;

    @BeforeEach
    void setUp() {
        patientDTO = new PatientDTO();
            patientDTO.setId((long) 1);
            patientDTO.setName("Eduardo");
            patientDTO.setSurnames("García Espeso");
            patientDTO.setSocialSecurityNumber("5656565656565R");
            patientDTO.setBirthday(LocalDate.now());
            patientDTO.setStreet("Avenida Madrid");
            patientDTO.setPortal(1);
            patientDTO.setNumber(1);
            patientDTO.setDoctorId((long) 1);
            patientDTO.setPhoto("photo");
        familyBackgroundDTO = new FamilyBackgroundDTO();
            familyBackgroundDTO.setInformation("info");
        medicalHistoryInfo = "info";

        when(patientClient.findById((long) 1)).thenReturn(patientDTO);
        when(patientClient.getFamilyBackgroundById((long) 1)).thenReturn(familyBackgroundDTO);
        when(patientClient.findMedicalHistoryByPatient((long) 1)).thenReturn(medicalHistoryInfo);
    }

    @Test
    void createPDF() throws Exception {
        assertTrue(medicalHistoryService.createPDF((long) 1).toString().contains("java.io.ByteArrayInputStream"));
    }
}