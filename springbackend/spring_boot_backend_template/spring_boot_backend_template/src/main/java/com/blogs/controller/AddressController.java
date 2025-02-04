package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogs.pojos.Address;
import com.blogs.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    
    @PostMapping("/add/{userId}")
    public ResponseEntity<?> saveContactInfo(@PathVariable Long userId , @RequestBody Address address) {
        Address savedContactInfo = addressService.saveContactInfo(userId,address);
        return ResponseEntity.ok(savedContactInfo);
    }

   
   
}
