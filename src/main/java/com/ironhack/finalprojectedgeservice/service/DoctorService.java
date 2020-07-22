package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.client.DoctorClient;
import com.ironhack.finalprojectedgeservice.model.dto.AddressDTO;
import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    DoctorClient doctorClient;

    public DoctorDTO findById(Long id) {
        return doctorClient.findById(id);
    }

    public void updateAddress(Long id, AddressDTO addressDTO) {
        doctorClient.updateAddress(id, addressDTO);
    }
}
