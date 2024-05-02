package com.pennant.shoppingcart.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pennant.shoppingcart.models.CustomerModel;
import com.pennant.shoppingcart.models.ProductListModel;
import com.pennant.shoppingcart.models.ProductModel;

import JDBCUTILITIES.JdbcUtil;

public class OrderDALImpl implements IOrderDAL {
	@Override
	public Integer orderItems(ProductListModel productsInCart, CustomerModel customer) {
		Integer orderId = null;
		Connection con = JdbcUtil.getConnection();
		try {
			con.setAutoCommit(false);
			con.setSavepoint("before");
			PreparedStatement psmt = con
					.prepareStatement("INSERT INTO i213_orders (o_total,c_id) VALUES (?,?) RETURNING o_id");
			psmt.setDouble(1, productsInCart.getOrderTotal());
			psmt.setInt(2, customer.getCust_Id());
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				orderId = rs.getInt("o_id");
				psmt = con.prepareStatement("insert into i213_order_products values(?,?,?,?)");
				for (ProductModel product : productsInCart) {
					psmt.setInt(1, orderId);
					psmt.setInt(2, product.getProd_Id());
					psmt.setInt(3, product.getProd_Qty());
					psmt.setDouble(4, product.getProd_Price());
					psmt.addBatch();
				}
				psmt.executeBatch();
				con.setSavepoint();
			}
			con.commit();
			JdbcUtil.closeConnections(con, psmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderId;
	}

	@Override
	public Double getGst(Integer id) {
		Double gst = null;
		Connection con = JdbcUtil.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(
					"select gst from i213_hsn_code where hsn_code in(select p_hsn_code from i213_products where p_id=?)");
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				gst = rs.getDouble("gst");
			}
			JdbcUtil.closeConnections(con, psmt, rs);
		} catch (SQLException e) {
		}
		return gst;
	}
}
