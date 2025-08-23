package com.ai.linear.regression.crud.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ai.linear.regression.crud.model.HouseData;

public class CSVUtils {

	private static final String FILE_NAME = "data.csv";

	public static void writeData(List<HouseData> dataList) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (HouseData data : dataList) {
				writer.write(data.getSize() + "," + data.getPrice());
				writer.newLine();
			}
		}
	}

	public static List<HouseData> readData() throws IOException {
		List<HouseData> dataList = new ArrayList<>();
		File file = new File(FILE_NAME);
		if (!file.exists())
			return dataList;

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				dataList.add(new HouseData(Double.parseDouble(parts[0]), Double.parseDouble(parts[1])));
			}
		}
		return dataList;
	}
}