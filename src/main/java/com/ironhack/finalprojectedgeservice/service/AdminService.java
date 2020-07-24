package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.AdminClient;
import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminClient adminClient;

    public void create(DoctorDTO doctorDTO) {
        adminClient.create(doctorDTO);
    }
}
