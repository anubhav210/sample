package com.div.sample;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream9ApiInprovement {

	public static void main(String[] args) {
		List<Integer> list = Stream.of(2, 2, 3, 4, 5, 6, 7, 8, 9, 10).takeWhile(i -> i < 5)
				.collect(Collectors.toList());
		System.out.println(list);

		System.out.println("============================================");
		List<Integer> list1 = Stream.of(2, 2, 3, 4, 5, 6, 7, 8, 9, 10).dropWhile(i -> i < 5)
				.collect(Collectors.toList());
		System.out.println(list1);
		System.out.println("============================================");

		List<Integer> list2 = Stream.of(2, 2, 3, 4, 5, null, 7, 8, 9, 10).dropWhile(i -> (i % 2 == 0))
				.collect(Collectors.toList());
		System.out.println(list2);
		System.out.println("============================================");

		Stream.iterate(1, i -> i <= 10, i -> i * 3).forEach(System.out::println);

		/*
		 * int _ = 10; System.out.println(_);
		 */

	}
}
