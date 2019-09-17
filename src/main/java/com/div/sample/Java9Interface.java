package com.div.sample;

public interface Java9Interface {

	default void test() {
		saySomething();
		sayPolitely();
	}

	private static void sayPolitely() {
		System.out.println("I'm private static method");
	}

	private void saySomething() {
		System.out.println("Hello... I'm private method");
	}

}
