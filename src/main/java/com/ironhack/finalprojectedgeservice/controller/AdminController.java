package com.ironhack.finalprojectedgeservice.controller;

import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
import com.ironhack.finalprojectedgeservice.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @ApiOperation(value="Create a doctor and her user")
    @PostMapping("/user/doctor/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody  DoctorDTO doctorDTO) {
        System.out.println(doctorDTO);
        adminService.create(doctorDTO);
    }
}
