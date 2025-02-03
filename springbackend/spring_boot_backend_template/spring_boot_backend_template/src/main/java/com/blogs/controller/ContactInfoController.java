package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogs.pojos.ContactInfo;
import com.blogs.service.ContactInfoService;

import java.util.List;

@RestController
@RequestMapping("/api/contact-info")
public class ContactInfoController {

    @Autowired
    private ContactInfoService contactInfoService;

    // ✅ Save Contact Info
    @PostMapping("/save")
    public ResponseEntity<?> saveContactInfo(@RequestParam("userId")Long userId , @RequestBody ContactInfo contactInfo) {
        ContactInfo savedContactInfo = contactInfoService.saveContactInfo(userId,contactInfo);
        return ResponseEntity.ok(savedContactInfo);
    }

   
   
}
