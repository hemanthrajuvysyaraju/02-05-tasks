package com.pennant.shoppingcart.controllers;

import java.io.IOException;

import com.pennant.shoppingcart.ServiceFactory.ServiceFactory;
import com.pennant.shoppingcart.models.CustomerModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
		response.addHeader("Access-Control-Allow-Origin", "*");
		if (request.getRequestURI().endsWith("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			CustomerModel customer = new CustomerModel();
			customer.setCust_UserName(username);
			customer.setCust_PassWord(password);
			customer = ServiceFactory.getCustomerImpl().login_User(customer);
			HttpSession hs = request.getSession();
			hs.setAttribute("userdetails", customer);
			if (customer.getCust_Name() != null) {
				hs.setAttribute("username", customer.getCust_Name().trim());
				hs.setAttribute("id", customer.getCust_Id().toString());
				response.sendRedirect("http://localhost:8080/shoppingcartmvc/store.jsp");
			}
		} else if (request.getRequestURI().endsWith("signup")) {
			CustomerModel customer = new CustomerModel();
			String name = request.getParameter("name");
			String mobile = request.getParameter("mobileno");
			String location = request.getParameter("location");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			customer.setCust_Name(name);
			customer.setCust_Location(location);
			customer.setCust_Mobile(mobile);
			customer.setCust_UserName(username);
			customer.setCust_PassWord(password);
			Boolean status = ServiceFactory.getCustomerImpl().register_Customer(customer);
			if (status) {
				response.sendRedirect("http://localhost:8080/shoppingcartmvc/login.html");
			} else {
				response.sendRedirect("http://localhost:8080/shoppingcartmvc/signup.html");
			}
		}
	}

}
