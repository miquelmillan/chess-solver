package com.mm.cs.util;

import com.mm.cs.model.board.Board;
/**
 * 
 * Utility class to format board statuses into different formats
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 */
public class BoardFormatUtil {
	public static enum Format {
		FANCY,
		STANDARD
	};
	
	/**
	 * Formats the input board depending on the passed format criterion. In case of
	 * Format.FANCY it will format the board in a clean manner. Otherwise (Format.FULL) the
	 * board will be formatted in the standard way.
	 * 
	 * @param board The board to print
	 * @param format The format to apply
	 * @return The formatted board if the parameters are right, otherwise null
	 */
	public static String format(Board board, Format format){
		String result = null;
		if (board != null && format != null){
			switch (format){
			case FANCY:
				result = board.toString().replaceAll("x ", "o ");
				break;
				
			case STANDARD:
				result = board.toString();
				break;
			}
		}
		return result;
	}
}
