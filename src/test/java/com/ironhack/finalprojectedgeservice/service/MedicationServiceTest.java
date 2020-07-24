package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.PatientClient;
import com.ironhack.finalprojectedgeservice.model.dto.MedicationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MedicationServiceTest {

    @Autowired
    MedicationService medicationService;

    @MockBean
    PatientClient patientClient;

    private MedicationDTO medicationDTO;

    @BeforeEach
    void setUp() {
        medicationDTO = new MedicationDTO();
            medicationDTO.setInfo("Info");

        when(medicationService.findByPatient((long) 1)).thenReturn(medicationDTO);
    }

    @Test
    void findByPatient() {
        assertTrue(medicationService.findByPatient((long) 1).getInfo().equals("Info"));
    }
}