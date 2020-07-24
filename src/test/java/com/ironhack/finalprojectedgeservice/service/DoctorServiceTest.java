package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.DoctorClient;
import com.ironhack.finalprojectedgeservice.model.dto.AddressDTO;
import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
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
class DoctorServiceTest {

    @Autowired
    DoctorService doctorService;

    @MockBean
    DoctorClient doctorClient;

    private DoctorDTO  doctorDTO;
    private AddressDTO addressDTO;

    @BeforeEach
    void setUp() {
       doctorDTO = new DoctorDTO();
            doctorDTO.setId((long) 1);
            doctorDTO.setName("Eduardo");
            doctorDTO.setSurnames("García Espeso");
            doctorDTO.setSchoolNumber("355656565656Q");
            doctorDTO.setBirthday(LocalDate.now());
            doctorDTO.setStreet("Calle");
            doctorDTO.setPortal(2);
            doctorDTO.setPortal(1);
        addressDTO = new AddressDTO();
            addressDTO.setStreet("Calle");
            addressDTO.setPortal(20);
            addressDTO.setNumber(5);

       when(doctorClient.findById((long) 1)).thenReturn(doctorDTO);
       when(doctorClient.findAll()).thenReturn(List.of(doctorDTO));
    }

    @Test
    void findById() {
        assertTrue(doctorService.findById((long) 1).getName().equals("Eduardo"));
    }

    @Test
    void updateAddress() {
        doctorService.updateAddress((long) 1, addressDTO);
    }

    @Test
    void findAll() {
        assertTrue(doctorService.findAll().size() == 1);
    }
}