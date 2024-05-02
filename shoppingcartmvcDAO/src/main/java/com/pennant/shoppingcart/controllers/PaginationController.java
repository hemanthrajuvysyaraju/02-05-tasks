package com.pennant.shoppingcart.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.pennant.shoppingcart.ServiceFactory.ServiceFactory;
import com.pennant.shoppingcart.models.ProductListModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PaginationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
		response.addHeader("Access-Control-Allow-Origin", "*");
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer prod = Integer.parseInt(request.getParameter("prod"));
		ProductListModel products=ServiceFactory.getProductsImpl().getProducts(((page-1)*prod), prod);
		JSONObject obj= new JSONObject();
		JSONArray id_Arr= new JSONArray();
		JSONArray image_Arr= new JSONArray();
		JSONArray name_Arr= new JSONArray();
		JSONArray price_Arr= new JSONArray();
		products.forEach(product->{
			id_Arr.put(product.getProd_Id());
			image_Arr.put(product.getProd_Image());
			name_Arr.put(product.getProd_Name());
			price_Arr.put(product.getProd_Price());
		});
		obj.put("id",id_Arr);
		obj.put("image",image_Arr);
		obj.put("name",name_Arr);
		obj.put("price",price_Arr);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(obj);
	}

}
