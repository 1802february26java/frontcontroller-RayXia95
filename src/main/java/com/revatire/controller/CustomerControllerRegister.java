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

	Customer customer = new Customer(0, request.getParameter("firstName"), request.getParameter("lastName"),
		request.getParameter("username"), request.getParameter("password"));

	if (CustomerServiceAlpha.getCustomerService().registerCustomer(customer))
	{
	    request.getSession().setAttribute("loggedCustomer", customer);
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
	Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
	/* if customer is not looged in */
	if (customer == null)
	{
	    return "login.html";
	}

	/* Client is requesting the view*/
	if (request.getParameter("fetch") == null)
	{
	    return "list-customer.html";
	}
	else
	{
	    return CustomerServiceAlpha.getCustomerService().listAllCustomers();
	}
    }

}
