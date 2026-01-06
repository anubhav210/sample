package com.div.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stream {

	public static void main(String[] args) {

		List<Product> productsList = new ArrayList<>();
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		productsList.add(new Product(3, "Sony Laptop", 28000f));

		// STREAM FILTER

		// productsList.stream().filter(f -> f.getId() != 3).forEach(f ->
		// log.info(f.getName()));

		// productsList.stream().filter(f -> f.getName().equals("Sony
		// Laptop")).forEach(f -> log.info(f.getId()));

		/*
		 * productsList.stream().map(mapper -> { String s = mapper.getName();
		 * mapper.setName(s.toUpperCase()); return mapper; }).forEach(logger::info);
		 */

		// REDUCE METHOD

		float salary = productsList.stream().map(Product::getPrice).reduce(0.0f, (sum, price) -> sum + price);
		// log.info(salary);

		double totalPrice = productsList.stream().collect(Collectors.summingDouble(product -> product.price));
		// log.info(totalPrice);

		// log.info("All Match:- " + productsList.stream().allMatch(f ->
		// f.getName().contains("Laptop")));

		// log.info("Any match:- " + productsList.stream().anyMatch(f -> f.getId() ==
		// 4));

		// log.info("none match:- " + productsList.stream().noneMatch(f -> f.getId()
		// == 4));

		// log.info("find any:- " + productsList.stream().filter(f -> f.getId() ==
		// 3).findAny().get().getName());

		// log.info("find first:- " + productsList.stream().filter(f -> f.getId() ==
		// 3).findFirst().get().getName());

		// FLAT MAP
		List<Integer> primeNumbers = Arrays.asList(5, 7, 11, 13);

		List<Integer> oddNumbers = Arrays.asList(1, 3, 5);

		List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> listOfListofInts = Arrays.asList(primeNumbers, oddNumbers, evenNumbers);
		// log.info(listOfListofInts);

		List<Integer> listOfInteger = listOfListofInts.stream().flatMap(f -> f.stream()).collect(Collectors.toList());
		// log.info(listOfInteger);

		// STREAM GENERATE METHOD // GENERATE INFITE SEQUESTION UNORDERED STREAM

		// java.util.stream.Stream.generate(UUID::randomUUID).limit(5).forEach(System.out::println);

		// It returns an infinite sequential ordered Stream

		// java.util.stream.Stream.iterate(5L, n -> n +
		// 1).limit(5).forEach(System.out::println);

		// MAX METHOD IN STREAM

		Product productMax = productsList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1)
				.get();
		// log.info("MAX PRICIE-> " + productMax.getPrice());

		// MIN METHOD IN STREAM

		Product productMin = productsList.stream().max((product1, product2) -> product1.price < product2.price ? 1 : -1)
				.get();
		// log.info("MIN PRICIE-> " + productMin.getPrice());

		// COUNT FUNCTION USING STREAM
		// log.info(productsList.stream().filter(f -> f.getPrice() >
		// 28000f).count());

		// LIST TO SET IN STREAM
		// productsList.stream().map(Product::getPrice).collect(Collectors.toSet()).forEach(logger::info);

		// LIST TO MAP

		List<Product> proList = new ArrayList<>();
		proList.add(new Product(1, "HP Laptop", 25000f));
		proList.add(new Product(2, "Dell Laptop", 30000f));
		proList.add(new Product(3, "Lenevo Laptop", 28000f));
		proList.add(new Product(4, "Sony Laptop", 28000f));
		// log.info(proList.stream().collect(Collectors.toMap(k -> k.id, v ->
		// v.name)));

		// PARTISION BY
		Map<Boolean, List<Product>> partionedByList = productsList.stream()
				.collect(Collectors.partitioningBy(f -> f.getPrice() > 28000f));

		// log.info(partionedByList.get(true));
		// log.info(partionedByList.get(false));

		// DIFFERENCE B/W stream and parallet stream
		// productsList.parallelStream().forEach(f -> log.info(f.getId()));
		log.info("==================================================");
		// productsList.stream().forEach(f -> log.info(f.getId()));

		// LIST TO ARRAY
		Object[] ppList = productsList.stream().toArray();
		//log.info(ppList);
		List<Object> pp = Arrays.asList(ppList);
		//log.info(pp);

		List<Integer> intList = Arrays.asList(1, 20, 3, 4, 10, 5, 9, 2, 20, 30);
		// intList.stream().forEachOrdered(logger::info);
		log.info("==================================================>>>>");
		intList.stream().filter(f -> f>2).peek(a -> log.info("{}", a)).filter(f -> f>10).peek(a -> log.info("next result :-  "+a)).collect(Collectors.toList());

	}
}
