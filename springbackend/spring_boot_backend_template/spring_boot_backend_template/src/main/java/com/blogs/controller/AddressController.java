package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogs.custom_exception.ResourceNotFoundException;
import com.blogs.pojos.Address;
import com.blogs.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressRepository addressService;

    // ✅ Save Contact Info
    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addAddress(@PathVariable Long userId, @RequestBody Address address) {
        try {
            Address savedAddress = addressService.saveAddress(userId, address);
            return ResponseEntity.ok(savedAddress);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred while saving the address.");
        }
    }

    // ✅ Get Contact Info by ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllAddressesByUserId(@PathVariable Long userId) {
        try {
            List<Address> addresses = addressService.getAddressesByUserId(userId);
            if (addresses.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(addresses);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred while fetching the addresses.");
        }
    }
}
