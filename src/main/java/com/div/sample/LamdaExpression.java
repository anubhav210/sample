package com.div.sample;

import org.apache.log4j.Logger;

public class LamdaExpression {
	static final Logger logger = Logger.getLogger(LamdaExpression.class);

	public static void main(String[] args) {

		LamdaExpressionInterface l = new LamdaExpressionInterface() {

			public void draw() {
				logger.info("lamda expression");
			}
		};
		l.draw();

		LamdaExpressionInterface lm = () -> logger.info("using lamda expression");

		lm.draw();

	}
}
