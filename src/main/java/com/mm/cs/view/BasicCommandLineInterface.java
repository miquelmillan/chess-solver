package com.mm.cs.view;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class BasicCommandLineInterface {

	public Long solveChessProblem(int rows, int columns, int knight, int rook,
			int bishop, int queen, int king) {
		Long result = System.currentTimeMillis();

		System.out.println("Rows:		" + rows);
		System.out.println("Columns:	" + columns);
		System.out.println("Knights:	" + knight);
		System.out.println("Rooks:		" + rook);
		System.out.println("Bishops:	" + bishop);
		System.out.println("Queens: 	" + queen);
		System.out.println("Kings:		" + king);

		return result;
	}

	private int parseNumber(String param){
		int result = -1;
		try {
			result = Integer.parseInt(param);
		} catch (NumberFormatException nfe){
			//do nothing
		}
		return result;
	}
	
	@SuppressWarnings("static-access")
	public static void main(String... args) {
		int result = 0;

		Options options = new Options();
		Option rows = OptionBuilder.hasArg().withArgName("rows")
				.withDescription("Number of rows").create("rows");
		
		Option columns = OptionBuilder.hasArg().withArgName("columns")
				.withDescription("Number of columns").create("columns");
		
		Option knight = OptionBuilder.hasArg().withArgName("knight")
				.withDescription("Number of knights").create("knight");
		
		Option rook = OptionBuilder.hasArg().withArgName("rook")
				.withDescription("Number of rooks").create("rook");
		
		Option bishop = OptionBuilder.hasArg().withArgName("bishop")
				.withDescription("Number of bishops").create("bishop");
		
		Option queen = OptionBuilder.hasArg().withArgName("queen")
				.withDescription("Number of queens").create("queen");
		
		Option king = OptionBuilder.hasArg().withArgName("king")
				.withDescription("Number of kings").create("king");
		
		Option help = new Option("help",  "Chess solver command line interface. Rows and"
										+ "columns parameter are mandatory. The number of"
										+ "knights, rooks, bishops, queens and kings are"
										+ "optional, but at least one of them must be provided"
										+ "in order to obtain results with sense.");

		options.addOption(rows);
		options.addOption(columns);
		options.addOption(knight);
		options.addOption(rook);
		options.addOption(bishop);
		options.addOption(queen);
		options.addOption(king);
		options.addOption(help);

		CommandLineParser parser = new BasicParser();
		try {
			CommandLine line = parser.parse(options, args);

			if (line.hasOption("help")) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("help text", options);
			} else {
				BasicCommandLineInterface bcli = new BasicCommandLineInterface();
				
				int rowsNumber = bcli.parseNumber(line.getOptionValue("rows"));
				int columnsNumber = bcli.parseNumber(line.getOptionValue("columns"));
				int knightNumber = bcli.parseNumber(line.getOptionValue("knight"));
				int rookNumber = bcli.parseNumber(line.getOptionValue("rook"));
				int bishopNumber = bcli.parseNumber(line.getOptionValue("bishop"));
				int queenNumber = bcli.parseNumber(line.getOptionValue("queen"));
				int kingNumber = bcli.parseNumber(line.getOptionValue("king"));
				
				if (rowsNumber > 0 && columnsNumber > 0) {
					bcli.solveChessProblem(	rowsNumber, columnsNumber, knightNumber,
											rookNumber, bishopNumber,
											queenNumber, kingNumber);
				} else {
					System.out.println("Parameter not declared");
					HelpFormatter formatter = new HelpFormatter();
					formatter.printHelp("chess-solver", options);
					result = 1;
				}
			}
		} catch (ParseException exp) {
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		}

		System.exit(result);
	}
}