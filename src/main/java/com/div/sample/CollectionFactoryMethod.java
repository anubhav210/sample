package com.div.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
			System.out.println(l);
		}

		// USING JAVA 9
		System.out.println("========================================================");
		List<String> list1 = List.of("Java", "JavaFX", "Spring", "Hibernate", "JSP");

		for (String l : list1) {
			System.out.println(l);
		}

		System.out.println("========================================================");

		Set<String> set = Set.of("Java", "JavaFX", "Spring", "Hibernate", "JSP");
		for (String l : set) {
			System.out.println(l);
		}

		System.out.println("========================================================");

		Map<String, Integer> map1 = Map.of("test", 1, "test1", 2);
		System.out.println(map1);

		System.out.println("========================================================");

		// Creating Map Entry
		Map.Entry<Integer, String> e1 = Map.entry(101, "Java");
		Map.Entry<Integer, String> e2 = Map.entry(102, "Spring");
		// Creating Map using map entries
		Map<Integer, String> map = Map.ofEntries(e1, e2);
		// Iterating Map
		for (Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		System.out.println("========================================================");

		// PROCESS API INHANCEMENT=============>
		ProcessHandle currentProcess = ProcessHandle.current(); // Current processhandle
		System.out.println("Process Id: " + currentProcess.pid()); // Process id
		System.out.println("Direct children: " + currentProcess.children()); // Direct children of the process
		System.out.println("Class name: " + currentProcess.getClass()); // Class name
		System.out.println("All processes: " + ProcessHandle.allProcesses()); // All current processes
		System.out.println("Process info: " + currentProcess.info()); // Process info
		System.out.println("Is process alive: " + currentProcess.isAlive());
		System.out.println("Process's parent " + currentProcess.parent()); // Parent of the process

		System.out.println("========================================================");

		// VERSION INFORMATION===================>

		Runtime.Version version = Runtime.version(); // Getting runtime version instance
		System.out.println("Current version is " + version); // Getting current Java version
		System.out.println("Major version number " + version.major()); // Getting major version number
		System.out.println("Minor version number " + version.minor()); // Getting minor version number
		System.out.println("Security version number " + version.security()); // Getting security version number
		System.out.println("Pre-released information " + version.pre()); // Getting pre-release version information
		System.out.println("Build Number " + version.build()); // Getting Optional build number

	}
}