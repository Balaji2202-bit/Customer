package com.customer.customer.controller;

import com.customer.customer.entity.Customer;
import com.customer.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    private CustomerService customerService;
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }
    @PostMapping
    public Customer addNewCustomer(@RequestBody Customer customer)
    {
//        return new ResponseEntity(customerService.addCustomer(customer),HttpStatus.CREATED);
        return customerService.addCustomer(customer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable(value = "id") long id,
                                           @RequestBody Customer customer)
    {
        return new ResponseEntity<>(customerService.updateCustomer(customer,id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getter()
    {
        return  new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteData(@PathVariable(name = "id") long id)
    {
        customerService.delete(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Customer> getDataById(@PathVariable long id)
    {
        return new ResponseEntity<>(customerService.getDetailsById(id),HttpStatus.OK);
    }
}
