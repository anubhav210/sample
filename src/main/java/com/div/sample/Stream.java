package com.div.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

class Product {

	public Product() {
	}

	int id;
	String name;
	float price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}

public class Stream {
	static final Logger logger = Logger.getLogger(Stream.class);

	public static void main(String[] args) {

		List<Product> productsList = new ArrayList<>();
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		productsList.add(new Product(3, "Sony Laptop", 28000f));

		// STREAM FILTER

		productsList.stream().filter(f -> f.getId() != 3).forEach(f -> logger.info(f.getName()));

		productsList.stream().filter(f -> f.getName().equals("Sony Laptop")).forEach(f -> logger.info(f.getId()));

		productsList.stream().map(mapper -> {
			String s = mapper.getName();
			mapper.setName(s.toUpperCase());
			return mapper;
		}).forEach(logger::info);

		// REDUCE METHOD

		float salary = productsList.stream().map(Product::getPrice).reduce(0.0f, (sum, price) -> sum + price);
		logger.info(salary);

		double totalPrice = productsList.stream().collect(Collectors.summingDouble(product -> product.price));
		logger.info(totalPrice);

		logger.info("All Match:- " + productsList.stream().allMatch(f -> f.getName().contains("Laptop")));

		logger.info("Any match:- " + productsList.stream().anyMatch(f -> f.getId() == 4));

		logger.info("none match:- " + productsList.stream().noneMatch(f -> f.getId() == 4));

		logger.info("find any:- " + productsList.stream().filter(f -> f.getId() == 3).findAny().get().getName());

		logger.info("find first:- " + productsList.stream().filter(f -> f.getId() == 3).findFirst().get().getName());

		// FLAT MAP
		List<Integer> primeNumbers = Arrays.asList(5, 7, 11, 13);

		List<Integer> oddNumbers = Arrays.asList(1, 3, 5);

		List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> listOfListofInts = Arrays.asList(primeNumbers, oddNumbers, evenNumbers);
		System.out.println(listOfListofInts);

		List<Integer> listOfInteger = listOfListofInts.stream().flatMap(f -> f.stream()).collect(Collectors.toList());
		System.out.println(listOfInteger);

		// STREAM GENERATE METHOD // GENERATE INFITE SEQUESTION UNORDERED STREAM

		java.util.stream.Stream.generate(UUID::randomUUID).limit(5).forEach(System.out::println);

		// It returns an infinite sequential ordered Stream

		java.util.stream.Stream.iterate(5L, n -> n + 1).limit(5).forEach(System.out::println);

		// MAX METHOD IN STREAM

		Product productMax = productsList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1)
				.get();
		logger.info("MAX PRICIE->       " + productMax.getPrice());

		// MIN METHOD IN STREAM

		Product productMin = productsList.stream().max((product1, product2) -> product1.price < product2.price ? 1 : -1)
				.get();
		logger.info("MIN PRICIE->       " + productMin.getPrice());

		// COUNT FUNCTION USING STREAM
		logger.info(productsList.stream().filter(f -> f.getPrice() > 28000f).count());

		// LIST TO SET IN STREAM
		productsList.stream().map(Product::getPrice).collect(Collectors.toSet()).forEach(logger::info);

		// LIST TO MAP

		List<Product> proList = new ArrayList<>();
		proList.add(new Product(1, "HP Laptop", 25000f));
		proList.add(new Product(2, "Dell Laptop", 30000f));
		proList.add(new Product(3, "Lenevo Laptop", 28000f));
		proList.add(new Product(4, "Sony Laptop", 28000f));
		logger.info(proList.stream().collect(Collectors.toMap(k -> k.id, v -> v.name)));

	}
}
