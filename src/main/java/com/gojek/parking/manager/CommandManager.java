package com.gojek.parking.manager;

import java.util.Map;

public class CommandManager {
	
	private static Map<String, Integer> commandMap = Map.ofEntries(
			entry("",1)
	);
	
	Map<String, String> test1 = Map.of(
		    "a", "b",
		    "c", "d"
		);

		// this works for any number of elements:
		Map<String, String> test2 = Map.ofEntries(
		    entry("a", "b"),
		    entry("c", "d")
		);
	
	/**
	 * @return the commandMap
	 */
	public Map<String, Integer> getCommandMap() {
		return commandMap;
	}

	/**
	 * @param commandMap the commandMap to set
	 */
	public void setCommandMap(Map<String, Integer> commandMap) {
		this.commandMap = commandMap;
	}
	

}
