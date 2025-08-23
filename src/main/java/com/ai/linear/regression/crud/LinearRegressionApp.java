package com.ai.linear.regression.crud;

import java.io.IOException;

import com.ai.linear.regression.crud.service.HouseDataService;

public class LinearRegressionApp {

	public static void main(String[] args) throws IOException {
		HouseDataService.performCRUD();
	}
}