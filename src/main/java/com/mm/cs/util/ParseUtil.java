package com.mm.cs.util;

/**
 * Utility class to parse Strings. Created to not depend on external libraries
 * as the needs are quite small
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 */
public class ParseUtil {
	/**
	 * Transforms a String to a positive int
	 * 
	 * @param param The String to parse
	 * @return a positive int if the string is numeric, -1 otherwise
	 */
	public static int parseNumber(String param){
		int result = -1;
		try {
			result = Integer.parseInt(param);
		} catch (NumberFormatException nfe){
			//do nothing
		}
		return result;
	}
}
