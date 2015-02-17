package com.mm.cs.view;

import java.util.Set;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.mm.cs.logic.ChessSolverLogic;
import com.mm.cs.logic.impl.ChessSolverLogicImpl;
import com.mm.cs.util.ParseUtil;

public class BasicCommandLineInterface {

	public int solveChessProblem(int rows, int columns, int knights, int rooks,
			int bishops, int queens, int kings) {
		int result = -1;
		
		try {
			Set<String> configs = null;
			ChessSolverLogic csl = new ChessSolverLogicImpl();
			configs = csl.solveChessBoard(rows, columns, knights, rooks, bishops, queens, kings);
			result = configs.size();
			//Show the solutions
			System.out.println("# of solutions: " + result);
			for (String config : configs){
				System.out.println("Solution: ");
				System.out.println(config);
			}
		} catch (Throwable t){
			//Throwable is not a recommended exception to catch normally, but
			//as this is our UI facade it's crucial to catch it in order to retrieve
			//the proper response in case of error
			result = -2;
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
				
				int rowsNumber = ParseUtil.parseNumber(line.getOptionValue("rows"));
				int columnsNumber = ParseUtil.parseNumber(line.getOptionValue("columns"));
				int knightNumber = ParseUtil.parseNumber(line.getOptionValue("knight"));
				int rookNumber = ParseUtil.parseNumber(line.getOptionValue("rook"));
				int bishopNumber = ParseUtil.parseNumber(line.getOptionValue("bishop"));
				int queenNumber = ParseUtil.parseNumber(line.getOptionValue("queen"));
				int kingNumber = ParseUtil.parseNumber(line.getOptionValue("king"));
				
				if (rowsNumber > 0 && columnsNumber > 0) {
					result = bcli.solveChessProblem(	rowsNumber, columnsNumber, knightNumber,
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