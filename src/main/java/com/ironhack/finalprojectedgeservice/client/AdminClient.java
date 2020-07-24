package com.ironhack.finalprojectedgeservice.client;

import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="admin-service", url="https://final-project-admin-service.herokuapp.com/")
public interface AdminClient {

    @PostMapping("/user/doctor/create")
    void create(@RequestBody DoctorDTO doctorDTO);

}
