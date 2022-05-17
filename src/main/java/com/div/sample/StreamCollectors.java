package com.div.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class StreamCollectors {

	static final Logger logger = Logger.getLogger(StreamCollectors.class);

	public static void main(String[] args) {

		List<Product> productsList = new ArrayList<>();
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		productsList.add(new Product(3, "Sony Laptop", 28000f));

		// AVERAGING DOUBLE
		logger.info(productsList.stream().collect(Collectors.averagingDouble(Product::getPrice)).floatValue());
				
		// AVERAGING DOUBLE
	    logger.info(productsList.stream().collect(Collectors.averagingDouble(Product::getPrice)).floatValue());
				

	}
}
