package com.ironhack.finalprojectedgeservice.client;

import com.ironhack.finalprojectedgeservice.model.dto.AddressDTO;
import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="doctor-service", url="https://final-project-doctor-service.herokuapp.com/")
public interface DoctorClient {

    @GetMapping("/doctor/find_by_id/{id}")
    DoctorDTO findById(@PathVariable Long id);

    @PutMapping("/doctor/update_address/{id}")
    void updateAddress(@PathVariable Long id,
                              @RequestBody AddressDTO addressDTO);

    @GetMapping("/doctor/find_all")
    List<DoctorDTO> findAll();

}
