package com.pennant.shoppingcart.DAL;

import com.pennant.shoppingcart.models.ProductListModel;

public interface IProductsDAL {

	public ProductListModel getProducts(Integer page,Integer limit);

	public ProductListModel getProductById(Integer id);
}
