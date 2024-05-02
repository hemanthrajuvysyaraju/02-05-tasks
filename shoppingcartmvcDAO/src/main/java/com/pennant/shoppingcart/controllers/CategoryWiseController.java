package com.pennant.shoppingcart.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.pennant.shoppingcart.ServiceFactory.ServiceFactory;
import com.pennant.shoppingcart.models.ProductListModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test", loadOnStartup = 1)
public class CategoryWiseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		Integer category = Integer.parseInt(request.getParameter("categoryid"));
		ProductListModel products = ServiceFactory.getProductsImpl().getProductById(category);
		JSONObject obj = new JSONObject();
		JSONArray id_Arr = new JSONArray();
		JSONArray name_Arr = new JSONArray();
		JSONArray image_Arr = new JSONArray();
		JSONArray price_Arr = new JSONArray();
		products.forEach((product) -> {
			id_Arr.put(product.getProd_Id());
			name_Arr.put(product.getProd_Name());
			image_Arr.put(product.getProd_Image());
			price_Arr.put(product.getProd_Price());
		});
		obj.put("product_id", id_Arr);
		obj.put("product_name", name_Arr);
		obj.put("product_image", image_Arr);
		obj.put("product_price", price_Arr);
		out.println(obj);
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
