package com.revatire.controller;

import javax.servlet.http.HttpServletRequest;

public interface CustomerController
{
    public Object register(HttpServletRequest request);

    /**
     * Get all customers in the database
     * 
     * If it's GET with no parameters, then we return the view.
     * if its GET with a parameters, then we return the list of users 
     */
    public Object getAllCustomers(HttpServletRequest request);
}
