package com.div.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionFactoryMethod {


	public static void main(String[] args) {

		// USING JAVA 8 SIMPLE WAY
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("JavaFX");
		list.add("Spring");
		list.add("Hibernate");
		list.add("JSP");
		for (String l : list) {
			log.info("{}", l);
		}

		// USING JAVA 9
		log.info("{}", "========================================================");
		List<String> list1 = List.of("Java", "JavaFX", "Spring", "Hibernate", "JSP");

		for (String l : list1) {
			log.info("{}", l);
		}

		log.info("{}", "========================================================");

		Set<String> set = Set.of("Java", "JavaFX", "Spring", "Hibernate", "JSP");
		for (String l : set) {
			log.info("{}", l);
		}

		log.info("{}", "========================================================");

		Map<String, Integer> map1 = Map.of("test", 1, "test1", 2);
		log.info("{}", map1);

		log.info("{}", "========================================================");

		// Creating Map Entry
		Map.Entry<Integer, String> e1 = Map.entry(101, "Java");
		Map.Entry<Integer, String> e2 = Map.entry(102, "Spring");
		// Creating Map using map entries
		Map<Integer, String> map = Map.ofEntries(e1, e2);
		// Iterating Map
		for (Map.Entry<Integer, String> m : map.entrySet()) {
			log.info("{}", m.getKey() + " " + m.getValue());
		}

		log.info("{}", "========================================================");

		// PROCESS API INHANCEMENT=============>
		ProcessHandle currentProcess = ProcessHandle.current(); // Current processhandle
		log.info("{}", "Process Id: " + currentProcess.pid()); // Process id
		log.info("{}", "Direct children: " + currentProcess.children()); // Direct children of the process
		log.info("{}", "Class name: " + currentProcess.getClass()); // Class name
		log.info("{}", "All processes: " + ProcessHandle.allProcesses()); // All current processes
		log.info("{}", "Process info: " + currentProcess.info()); // Process info
		log.info("{}", "Is process alive: " + currentProcess.isAlive());
		log.info("{}", "Process's parent " + currentProcess.parent()); // Parent of the process

		log.info("{}", "========================================================");

		// VERSION INFORMATION===================>

		Runtime.Version version = Runtime.version(); // Getting runtime version instance
		log.info("{}", "Current version is " + version); // Getting current Java version
		log.info("{}", "Major version number " + version.major()); // Getting major version number
		log.info("{}", "Minor version number " + version.minor()); // Getting minor version number
		log.info("{}", "Security version number " + version.security()); // Getting security version number
		log.info("{}", "Pre-released information " + version.pre()); // Getting pre-release version information
		log.info("{}", "Build Number " + version.build()); // Getting Optional build number

	}
}