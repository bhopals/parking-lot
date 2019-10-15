package com.gojek.parking.manager;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
	
	private static Map<String, Integer> commandMap = new HashMap<String, Integer>(){{
        
    }};
	
	
	/**
	 * @return the commandMap
	 */
	public Map<String, Integer> getCommandMap() {
		return commandMap;
	}

	
	
}
