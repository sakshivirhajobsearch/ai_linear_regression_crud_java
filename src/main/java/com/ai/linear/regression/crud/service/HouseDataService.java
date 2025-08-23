package com.ai.linear.regression.crud.service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.ai.linear.regression.crud.model.HouseData;
import com.ai.linear.regression.crud.util.CSVUtils;

public class HouseDataService {

	public static void performCRUD() throws IOException {

		Scanner scanner = new Scanner(System.in);
		List<HouseData> dataList = CSVUtils.readData();

		while (true) {
			System.out.println("\n1. Add Data\n2. View Data\n3. Delete Data\n4. Train Model\n5. Exit");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter size: ");
				double size = scanner.nextDouble();
				System.out.print("Enter price: ");
				double price = scanner.nextDouble();
				dataList.add(new HouseData(size, price));
				CSVUtils.writeData(dataList);
				break;

			case 2:
				for (HouseData d : dataList) {
					System.out.println("Size: " + d.getSize() + " -> Price: " + d.getPrice());
				}
				break;

			case 3:
				System.out.print("Enter index to delete: ");
				int index = scanner.nextInt();
				if (index >= 0 && index < dataList.size()) {
					dataList.remove(index);
					CSVUtils.writeData(dataList);
				} else {
					System.out.println("Invalid index.");
				}
				break;

			case 4:
				LinearRegressionModel.train(dataList);
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
	}
}
