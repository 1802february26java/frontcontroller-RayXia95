package com.revature.service;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerService
{
    // Only receive customer or sends out customer
    public boolean registerCustomer(Customer customer);

    public boolean registerCustomerSecure(Customer customer);

    public List<Customer> listAllCustomers();

    public Customer authenticate(Customer customer);
}
