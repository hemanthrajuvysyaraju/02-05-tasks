package com.pennant.shoppingcart.models;

public class ProductModel {
	private Integer prod_Cat_Id;
	private Integer prod_Id;
	private String prod_Name;
	private Double prod_Price;
	private String prod_Image;
	private Integer prod_Qty;
	private Double prod_TotalFare;
	
	public Integer getProd_Cat_Id() {
		return prod_Cat_Id;
	}

	public void setProd_Cat_Id(Integer prod_Cat_Id) {
		this.prod_Cat_Id = prod_Cat_Id;
	}

	public Integer getProd_Id() {
		return prod_Id;
	}

	public void setProd_Id(Integer prod_Id) {
		this.prod_Id = prod_Id;
	}

	public String getProd_Name() {
		return prod_Name;
	}

	public void setProd_Name(String prod_Name) {
		this.prod_Name = prod_Name;
	}

	public Double getProd_Price() {
		return prod_Price;
	}

	public void setProd_Price(Double prod_Price) {
		this.prod_Price = prod_Price;
	}

	public String getProd_Image() {
		return prod_Image;
	}

	public void setProd_Image(String prod_Image) {
		this.prod_Image = prod_Image;
	}

	public Integer getProd_Qty() {
		return prod_Qty;
	}

	public void setProd_Qty(Integer prod_Qty) {
		this.prod_Qty = prod_Qty;
	}

	public Double getProd_TotalFare() {
		return prod_TotalFare;
	}

	public void setProd_TotalFare(Double prod_TotalFare) {
		this.prod_TotalFare = prod_TotalFare;
	}

}
