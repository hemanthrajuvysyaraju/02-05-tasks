package com.pennant.shoppingcart.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pennant.shoppingcart.models.CustomerModel;

import JDBCUTILITIES.JdbcUtil;

public class CustomerDALImpl implements ICustomerDAL {

	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public Boolean register_Customer(CustomerModel customer) {
		con = JdbcUtil.getConnection();
		try {
			psmt = con.prepareStatement(
					"insert into i213_customers (c_name,c_mobile,c_location,c_username,c_password) values(?,?,?,?,?)");
			psmt.setString(1, customer.getCust_Name());
			psmt.setString(2, customer.getCust_Mobile());
			psmt.setString(3, customer.getCust_Location());
			psmt.setString(4, customer.getCust_UserName());
			psmt.setString(5, customer.getCust_PassWord());
			psmt.execute();
			JdbcUtil.closeConnections(con, psmt, rs);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CustomerModel login_User(CustomerModel customer) {
		con = JdbcUtil.getConnection();
		try {
			psmt = con.prepareStatement("select * from i213_customers where c_username=?");
			psmt.setString(1, customer.getCust_UserName());
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (customer.getCust_PassWord().equals(rs.getString("c_password"))) {
					customer.setCust_Id(rs.getInt("c_id"));
					customer.setCust_Name(rs.getString("c_name"));
					customer.setCust_Mobile(rs.getString("c_mobile"));
					customer.setCust_Location(rs.getString("c_location"));
				}
			}
			JdbcUtil.closeConnections(con, psmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
