package com.pennant.shoppingcart.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pennant.shoppingcart.models.CategoryListModel;
import com.pennant.shoppingcart.models.CategoryModel;

import JDBCUTILITIES.JdbcUtil;

public class CategoryDalImpl implements ICategoryDAL {
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public CategoryListModel getCategories() {
		CategoryListModel categories = new CategoryListModel();
		con = JdbcUtil.getConnection();
		try {
			psmt = con.prepareStatement("select * from i213_product_category");
			rs = psmt.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCat_id(rs.getInt("p_cat_id"));
				category.setCat_name(rs.getString("category_name"));
				categories.add(category);
			}
			JdbcUtil.closeConnections(con, psmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
}
