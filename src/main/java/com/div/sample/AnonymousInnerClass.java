package com.div.sample;

import java.util.ArrayList;
import java.util.List;

abstract class ABCD<T> {
	abstract T show(T a, T b);
}

public class AnonymousInnerClass {
	public static void main(String[] args) {
		ABCD<Integer> a = new ABCD<>() { // diamond operator is empty, compiler infer type in java 7,8 not support
			Integer show(Integer a, Integer b) {
				return a + b;
			}
		};

		int result = a.show(10, 20);
		System.out.println("Addtion is :" + result);

		AnonymousInnerClass p = new AnonymousInnerClass();
		List<String> list = new ArrayList<>();
		list.add("Laptop");
		list.add("Tablet");
		p.display(list);
		

	}

	@SafeVarargs
	private void display(List<String>... products) { // Not using @SaveVarargs
		for (List<String> product : products) {
			System.out.println(product);
			
		}
	}
}