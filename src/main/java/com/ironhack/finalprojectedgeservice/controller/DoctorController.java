package com.ironhack.finalprojectedgeservice.controller;

import com.ironhack.finalprojectedgeservice.model.dto.AddressDTO;
import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
import com.ironhack.finalprojectedgeservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctor/find_by_id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO findById(@PathVariable Long id) {
        return doctorService.findById(id);
    }

    @PutMapping("/doctor/update_address/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAddress(@PathVariable Long id,
                              @RequestBody AddressDTO addressDTO) {
        doctorService.updateAddress(id, addressDTO);
    }
}
