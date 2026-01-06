package com.div.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Java9Interface {

	public static final Logger log = LoggerFactory.getLogger(Java9Interface.class);

	default void test() {
		saySomething();
		sayPolitely();
	}

	private static void sayPolitely() {
		log.info("I'm private static method");
	}

	private void saySomething() {
		log.info("Hello... I'm private method");
	}

}
