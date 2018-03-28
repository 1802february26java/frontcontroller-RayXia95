package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revatire.controller.CustomerControllerRegister;
import com.revatire.controller.HomeControllerImpl;
import com.revatire.controller.LoginControllerLogout;

public class RequestHelper
{
    private RequestHelper()
    {}

    public static Object process(HttpServletRequest request)
    {
	switch (request.getRequestURI())
	{
	    case "/FrontController/login.do":
		return LoginControllerLogout.getInstance().login(request);
	    case "/FrontController/logout.do":
		return LoginControllerLogout.getInstance().logout(request);
	    case "/FrontController/register.do":
		return CustomerControllerRegister.getInstance().register(request);
	    case "/FrontController/getAll.do":
		return CustomerControllerRegister.getInstance().getAllCustomers(request);
	    case "/FrontController/home.do":
		return HomeControllerImpl.getInstance().home(request);
	    default:
		return "404.html";
	}
    }
}
