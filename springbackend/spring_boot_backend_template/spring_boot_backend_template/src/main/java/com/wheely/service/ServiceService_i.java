package com.wheely.service;

import java.util.List;

import com.wheely.pojos.Category;

public interface ServiceService_i {
	public List<Category> getAllCategories();
    public com.wheely.pojos.Service createService(com.wheely.pojos.Service service);
    public List<com.wheely.pojos.Service> getAllServices();
    public List<com.wheely.pojos.Service> getServicesByCategory(Long categoryId);
    public com.wheely.pojos.Service getServiceById(Long id);
    public com.wheely.pojos.Service updateService(Long id, com.wheely.pojos.Service service);
    public boolean deleteService(Long id);

}
