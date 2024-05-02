package com.pennant.shoppingcart.models;

import java.util.ArrayList;

public class ProductListModel extends ArrayList<ProductModel> {
	private static final long serialVersionUID = -935838833218226171L;
	private Double orderTotal;
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
}
