package com.ai.linear.regression.crud.model;

public class HouseData {
	
	private double size;
	private double price;

	public HouseData(double size, double price) {
		this.size = size;
		this.price = price;
	}

	public double getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}