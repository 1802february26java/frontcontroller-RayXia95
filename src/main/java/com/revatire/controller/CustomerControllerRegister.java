package com.revatire.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Customer;
import com.revature.service.CustomerServiceAlpha;

public class CustomerControllerRegister implements CustomerController
{
    private static CustomerControllerRegister customerRegister = new CustomerControllerRegister();

    private CustomerControllerRegister()
    {}

    public static CustomerControllerRegister getInstance()
    {
	return customerRegister;
    }

    @Override
    public Object register(HttpServletRequest request)
    {
	if (request.getMethod().equals("GET"))
	{
	    return "register.html";
	}

	Customer customer = new Customer(0, request.getParameter("firstname"), request.getParameter("lastname"),
		request.getParameter("username"), request.getParameter("password"));

	if (CustomerServiceAlpha.getCustomerService().registerCustomer(customer))
	{
	    request.getSession().setAttribute("customer", customer);
	    return new ClientMessage("REGISTRATION SUCCESSFUL");
	}
	else
	{
	    return new ClientMessage("Registerations failed, please try again");
	}
    }

    @Override
    public Object getAllCustomers(HttpServletRequest request)
    {
	/* Client is requesting the view*/
	if (request.getParameter("fetch") == null)
	{
	    return "all-customers.html";
	}
	else
	{
	    return CustomerServiceAlpha.getCustomerService().listAllCustomers();
	}
    }

}