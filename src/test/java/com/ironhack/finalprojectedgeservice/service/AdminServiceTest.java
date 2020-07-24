package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.AdminClient;
import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @MockBean
    AdminClient adminClient;

    private DoctorDTO doctorDTO;

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
    }

    @Test
    void create() {
        adminService.create(doctorDTO);
    }
}