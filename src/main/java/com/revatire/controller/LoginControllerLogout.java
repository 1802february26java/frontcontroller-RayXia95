package com.revatire.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Customer;
import com.revature.service.CustomerServiceAlpha;

public class LoginControllerLogout implements LoginController
{
    private static LoginControllerLogout loginController = new LoginControllerLogout();

    private LoginControllerLogout()
    {}

    public static LoginController getInstance()
    {
	return loginController;
    }

    @Override
    public Object login(HttpServletRequest request)
    {
	if (request.getMethod().equals("GET"))
	{
	    return "login.html";
	}

	Customer loggedCustomer = CustomerServiceAlpha.getCustomerService()
		.authenticate(new Customer(request.getParameter("username"), request.getParameter("password")));

	/* Store the customer information on the session */

	if (loggedCustomer == null)
	{
	    return new ClientMessage("AUTHENTICATION FAILED");
	}

	request.getSession().setAttribute("loggedCustomer", loggedCustomer);

	return loggedCustomer;
    }

    @Override
    public String logout(HttpServletRequest request)
    {
	return null;
    }

}
