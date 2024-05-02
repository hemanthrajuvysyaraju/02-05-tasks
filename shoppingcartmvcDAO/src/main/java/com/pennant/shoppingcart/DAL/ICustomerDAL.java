package com.pennant.shoppingcart.DAL;

import com.pennant.shoppingcart.models.CustomerModel;

public interface ICustomerDAL {
	public CustomerModel login_User(CustomerModel customer);

	public Boolean register_Customer(CustomerModel customer);
}
