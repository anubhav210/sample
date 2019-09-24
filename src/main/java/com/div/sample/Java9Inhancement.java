package com.div.sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;

public class Java9Inhancement implements Java9Interface {
	static final Logger logger = Logger.getLogger(Java9Inhancement.class);

	public static void main(String[] args) throws FileNotFoundException {

		Java9Interface java9Interface = new Java9Inhancement();
		java9Interface.test();

		// Try With Resource Enhancement IN JAVA 7 and 8

		try (FileOutputStream fileStream = new FileOutputStream("G:\\project\\JAVA_8_FEATURE\\document\\test.txt");) {
			String greeting = "Welcome to java 9 feature.";
			byte b[] = greeting.getBytes();
			fileStream.write(b);
			logger.info("File written");
		} catch (Exception e) {
			logger.info(e);
		}

		// Try With Resource Enhancement IN JAVA 9

		FileOutputStream fileStream = new FileOutputStream("G:\\project\\JAVA_8_FEATURE\\document\\test1.txt");
		try (fileStream) {
			String greeting = "Welcome to java 9 feature in text1 file.";
			byte b[] = greeting.getBytes();
			fileStream.write(b);
			System.out.println("File written");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
