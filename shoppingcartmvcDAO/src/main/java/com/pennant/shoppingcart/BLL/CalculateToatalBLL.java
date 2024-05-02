package com.pennant.shoppingcart.BLL;

import com.pennant.shoppingcart.DAL.OrderDALImpl;
import com.pennant.shoppingcart.models.ProductListModel;

public class CalculateToatalBLL {
	private static Double prods_TotalFare =0.0;

	public static void doProcess(ProductListModel products)
	{
		products.forEach(product->
		{
			OrderDALImpl ord = new OrderDALImpl();
			Double gst = ord.getGst(product.getProd_Id());
			Double total=(((gst/100)*product.getProd_Price())+product.getProd_Price())*product.getProd_Qty();
			product.setProd_TotalFare(total);
			prods_TotalFare += product.getProd_TotalFare();
		});
		products.setOrderTotal(prods_TotalFare);
	}
}
