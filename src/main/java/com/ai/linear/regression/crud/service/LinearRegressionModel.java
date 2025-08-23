package com.ai.linear.regression.crud.service;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import com.ai.linear.regression.crud.model.HouseData;

public class LinearRegressionModel {

	public static void train(List<HouseData> dataList) {

		SimpleRegression regression = new SimpleRegression();
		for (HouseData data : dataList) {
			regression.addData(data.getSize(), data.getPrice());
		}

		System.out.printf("Model: Price = %.2f * Size + %.2f%n", regression.getSlope(), regression.getIntercept());

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter house size to predict price: ");
		double inputSize = scanner.nextDouble();
		double predictedPrice = regression.predict(inputSize);
		System.out.println("Predicted Price: " + predictedPrice);
	}
}