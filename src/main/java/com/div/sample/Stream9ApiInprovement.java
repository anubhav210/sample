package com.div.sample;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stream9ApiInprovement {

	public static void main(String[] args) {
		List<Integer> list = Stream.of(2, 2, 3, 4, 5, 6, 7, 8, 9, 10).takeWhile(i -> i < 5)
				.collect(Collectors.toList());
		log.info("{}", list);

		log.info("{}", "============================================");
		List<Integer> list1 = Stream.of(2, 2, 3, 4, 5, 6, 7, 8, 9, 10).dropWhile(i -> i < 5)
				.collect(Collectors.toList());
		log.info("{}", list1);
		log.info("{}", "============================================");

		List<Integer> list2 = Stream.of(2, 2, 3, 4, 5, null, 7, 8, 9, 10).dropWhile(i -> (i % 2 == 0))
				.collect(Collectors.toList());
		log.info("{}", list2);
		log.info("{}", "============================================");

		Stream.iterate(1, i -> i <= 10, i -> i * 3).forEach(System.out::println);

		/*
		 * int _ = 10; log.info("{}", _);
		 */

	}
}
