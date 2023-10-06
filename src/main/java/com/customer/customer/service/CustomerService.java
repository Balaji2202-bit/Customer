package com.customer.customer.service;

import com.customer.customer.entity.Customer;
import com.customer.customer.exception.ResourceNotFoundException;
import com.customer.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }
    public Customer addCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Customer customer, Long id)
    {
        Customer customer1=customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post","id",id));
        customer1.setCustomerName(customer.getCustomerName());
        customer1.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
        customer1.setCustomerAddress(customer.getCustomerAddress());

        return customerRepository.save(customer1);
    }
    public List<Customer> getAll()
    {
        return customerRepository.findAll();
    }
    public void delete(Long id)
    {
       Customer customer=customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","id",id));
        customerRepository.deleteById(customer.getCustomerId());
    }
    public Customer getDetailsById(Long id)
    {
        Customer customer=customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","id",id));
        return customer;
    }
}
