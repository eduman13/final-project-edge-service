package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.PatientClient;
import com.ironhack.finalprojectedgeservice.model.dto.PatientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @MockBean
    PatientClient patientClient;

    private PatientDTO patientDTO;

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

        when(patientClient.findAllByDoctorId((long) 1)).thenReturn(List.of(patientDTO));
        when(patientClient.findById((long) 1)).thenReturn(patientDTO);
        when(patientClient.findAll()).thenReturn(List.of(patientDTO));
    }

    @Test
    void findByDoctor() {
        assertTrue(patientService.findByDoctor((long) 1).size() == 1);
    }

    @Test
    void findById() {
        assertTrue(patientService.findById((long) 1).getName().equals("Eduardo"));
    }

    @Test
    void findAll() {
        assertTrue(patientService.findAll().size() == 1);
    }

    @Test
    void deletePatient() {
        patientService.deletePatient((long) 1);
    }

    @Test
    void createPatient() {
        patientService.createPatient(patientDTO);
    }
}