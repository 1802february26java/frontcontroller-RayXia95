package com.revatire.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Customer;

public class HomeControllerImpl implements HomeController
{

    private static HomeControllerImpl homeController = new HomeControllerImpl();

    private HomeControllerImpl()
    {

    }

    public static HomeControllerImpl getInstance()
    {
	return homeController;
    }

    @Override
    public String home(HttpServletRequest request)
    {
	Customer loggedCustomer = (Customer) request.getSession().getAttribute("loggedCustomer");

	/* Store the customer information on the session */

	if (loggedCustomer == null)
	{
	    return "login.html";
	}
	return "home.html";
    }

}
