package com.wheely.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wheely.dao.CategoryRepository;
import com.wheely.dao.ServiceRepository;
import com.wheely.pojos.Category;

@Service
public class ServiceService implements ServiceService_i{

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public List<Category> getAllCategories() {
    	return categoryRepository.findAll();
    }
    
    public com.wheely.pojos.Service createService(com.wheely.pojos.Service service) {
        return serviceRepository.save(service);
    }

    public List<com.wheely.pojos.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<com.wheely.pojos.Service> getServicesByCategory(Long categoryId) {
        return serviceRepository.findByCategory_CategoryId(categoryId);
    }

    public com.wheely.pojos.Service getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
    public com.wheely.pojos.Service updateService(Long id, com.wheely.pojos.Service service) {
        Optional<com.wheely.pojos.Service> optionalService = serviceRepository.findById(id);
        if (optionalService.isPresent()) {
            com.wheely.pojos.Service entity = optionalService.get();
            entity.setName(service.getName());
            entity.setDescription(service.getDescription());
            entity.setPrice(service.getPrice());
            entity.setCategory(service.getCategory());
            serviceRepository.save(entity);
            return entity;
        }
        return null ;
    }

    // Delete a service
    public boolean deleteService(Long id) {
        if (serviceRepository.existsById(id)) {
            serviceRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
