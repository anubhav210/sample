package com.div.sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class LamdaExpression {
	static final Logger logger = Logger.getLogger(LamdaExpression.class);

	public static void main(String[] args) {

		// ================== WITH OUT LAMDA EXPRESSION============================
		LamdaExpressionInterface l = new LamdaExpressionInterface() {

			public void draw() {
				logger.info("without lamda expression");
			}

		};
		l.draw();

		// ====================WITH LAMDA EXPRESSION=================================

		LamdaExpressionInterface lm = () -> logger.info("using lamda expression");
		lm.draw();

		// ====================WITHOUT LAMDA EXPRESSION NO PARAMETER====================

		LamdaExpressionWithNoParameterInterface lmw = new LamdaExpressionWithNoParameterInterface() {
			@Override
			public String say() {
				return "WITHOUT LAMDA EXPRESSION WITH NO PARAMETER";
			}
		};
		logger.info(lmw.say());

		// ====================WITHOUT LAMDA EXPRESSION NO PARAMETER====================
		LamdaExpressionWithNoParameterInterface lmw1 = () -> "WITH LAMDA EXPRESSION WITH NO PARAMETER";
		logger.info(lmw1.say());

		// ========WITHOUT LAMDA EXPRESSION SIGLE PARAMETER=================

		LamdaExpressionWithSingleParameterInterface lmw2 = new LamdaExpressionWithSingleParameterInterface() {

			@Override
			public String say(String name) {
				return name;
			}

		};
		logger.info(lmw2.say("WITH OUT SINGLE PARAMETER"));

		// ========WITH LAMDA EXPRESSION SIGLE PARAMETER=================

		LamdaExpressionWithSingleParameterInterface lmw3 = name -> name;
		logger.info(lmw3.say("WITH SINGLE PARAMETER"));

		// ========WITHOUT LAMDA EXPRESSION MULTIPLE PARAMETER=================

		LamdaExpressionWithMultipleParameterInterface lmw4 = new LamdaExpressionWithMultipleParameterInterface() {

			@Override
			public int say(int a, int b) {
				return a + b;
			}
		};
		logger.info("SUM OF TWO NUMBER IS:- " + lmw4.say(10, 20));

		// ========WITH LAMDA EXPRESSION MULTIPLE PARAMETER=================

		LamdaExpressionWithMultipleParameterInterface lmw5 = (a, b) -> a + b;
		logger.info("SUM OF TWO NUMBER USING IS:- " + lmw5.say(10, 20));

		// ===========LAMDA EXPRESSION USING FOREACH=========================

		List<String> list = Arrays.asList("a", "b", "c", "d");
		list.forEach(f -> logger.info(f));
		list.forEach(logger::info);

		// ===========LAMDA EXPRESSION COMPARATOR=========================
		List<Integer> integerList = Arrays.asList(5, 9, 1, 3, 40, 16);
		integerList.forEach(logger::info);
		Collections.sort(integerList, (a, b) -> a.compareTo(b));
		integerList.forEach(logger::info);
		

	}
}
