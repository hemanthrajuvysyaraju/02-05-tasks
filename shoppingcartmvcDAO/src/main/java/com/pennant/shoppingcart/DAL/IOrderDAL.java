package com.pennant.shoppingcart.DAL;

import com.pennant.shoppingcart.models.CustomerModel;
import com.pennant.shoppingcart.models.ProductListModel;

public interface IOrderDAL {
	public Integer orderItems(ProductListModel productsInCart, CustomerModel customer);

	public Double getGst(Integer id);
}
