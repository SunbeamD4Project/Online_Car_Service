package com.blogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exception.ResourceNotFoundException;
import com.blogs.dao.Booking_Repository;
import com.blogs.dao.ContactInfoRepository;
import com.blogs.dao.User_Repository;
import com.blogs.pojos.Booking;
import com.blogs.pojos.ContactInfo;
import com.blogs.pojos.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactInfoService {

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @Autowired
    private User_Repository userRepository;

    @Autowired
    private Booking_Repository bookingRepository;

    public ContactInfo saveContactInfo(Long userId, ContactInfo contactInfo) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not found"));
        // Booking booking=bookingRepository.findById(bookingId).orElseThrow();
        ContactInfo contact = new ContactInfo();
        contact.setAddress(contactInfo.getAddress());
        contact.setCity(contactInfo.getCity());
        contact.setCountry(contactInfo.getCountry());
        contact.setMobile(contactInfo.getMobile());
        contact.setPinCode(contactInfo.getPinCode());
        contact.setState(contactInfo.getState());
        // contact.setBooking(booking);
        contact.setUser(user);

        return contactInfoRepository.save(contact);
    }

}