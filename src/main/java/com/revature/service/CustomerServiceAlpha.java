package com.revature.service;

import java.util.List;

import com.revature.model.Customer;
import com.revature.repository.CustomerRepositoryJdbc;

public class CustomerServiceAlpha implements CustomerService
{

    private static CustomerServiceAlpha customerService = new CustomerServiceAlpha();

    private CustomerServiceAlpha()
    {}

    public static CustomerServiceAlpha getCustomerService()
    {
	return customerService;
    }

    @Override
    public boolean registerCustomer(Customer customer)
    {
	return CustomerRepositoryJdbc.getInstance().insert(customer);
    }

    @Override
    public boolean registerCustomerSecure(Customer customer)
    {
	return CustomerRepositoryJdbc.getInstance().insertProcedure(customer);
    }

    @Override
    public List<Customer> listAllCustomers()
    {
	return CustomerRepositoryJdbc.getInstance().selectAll();
    }

    @Override
    public Customer authenticate(Customer customer)
    {
	Customer loggedCustomer = CustomerRepositoryJdbc.getInstance().select(customer);

	if (loggedCustomer.getPassword().equals(CustomerRepositoryJdbc.getInstance().getCustomerHash(customer)))
	{
	    return loggedCustomer;
	}

	return null;
    }

}
