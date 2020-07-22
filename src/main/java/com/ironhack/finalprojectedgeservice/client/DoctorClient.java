package com.ironhack.finalprojectedgeservice.client;

import com.ironhack.finalprojectedgeservice.model.dto.AddressDTO;
import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="doctor-service")
public interface DoctorClient {

    @GetMapping("/doctor/find_by_id/{id}")
    DoctorDTO findById(@PathVariable Long id);

    @PutMapping("/doctor/update_address/{id}")
    void updateAddress(@PathVariable Long id,
                              @RequestBody AddressDTO addressDTO);

}
