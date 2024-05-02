package com.pennant.shoppingcart.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pennant.shoppingcart.models.ProductListModel;
import com.pennant.shoppingcart.models.ProductModel;

import JDBCUTILITIES.JdbcUtil;

public class ProductsDALImpl implements IProductsDAL {
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public ProductListModel getProducts(Integer page,Integer limit) {
		con = JdbcUtil.getConnection();
		try {
			psmt = con.prepareStatement("select * from i213_products offset ? limit ?");
			psmt.setInt(1, page);
			psmt.setInt(2,limit);

		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return doProcess();
	}

	@Override
	public ProductListModel getProductById(Integer id) {
		new ProductListModel();
		con = JdbcUtil.getConnection();
		try {
			psmt = con.prepareStatement("select * from i213_products where p_cat_id=?");
			psmt.setInt(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doProcess();
	}

	private ProductListModel doProcess() {
		ProductListModel products = new ProductListModel();
		try {
			rs = psmt.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProd_Cat_Id(rs.getInt("p_cat_id"));
				product.setProd_Id(rs.getInt("p_id"));
				product.setProd_Name(rs.getString("p_name"));
				product.setProd_Price(rs.getDouble("price"));
				product.setProd_Image(rs.getString("p_image"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
