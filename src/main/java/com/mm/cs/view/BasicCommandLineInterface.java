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
import com.mm.cs.logic.concurrent.impl.ChessSolverLogicConcurrentImpl;
import com.mm.cs.logic.impl.ChessSolverLogicImpl;
import com.mm.cs.util.ParseUtil;
/**
 * Main class of the chess solver. It acts as UI, parsing the console parameters and
 * invoking the logic to solve the chess problem.
 * 
 * @author miquel.millan@gmail.com
 * @version 1.0
 *
 */
public class BasicCommandLineInterface {

	public int solveChessProblem(int rows, int columns, int knights, int rooks,
			int bishops, int queens, int kings, int parallelMode) {
		int result = -1;
		
		try {
			Set<String> configs = null;
			
			if (parallelMode == 1){
				ChessSolverLogic csl = new ChessSolverLogicConcurrentImpl();
				configs = csl.solveChessBoard(rows, columns, knights, rooks, bishops, queens, kings);
			} else {
				ChessSolverLogic csl = new ChessSolverLogicImpl();
				configs = csl.solveChessBoard(rows, columns, knights, rooks, bishops, queens, kings);
			}
			
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
		
		Option knight = OptionBuilder.hasArg().withArgName("knights")
				.withDescription("Number of knights").create("knights");
		
		Option rook = OptionBuilder.hasArg().withArgName("rooks")
				.withDescription("Number of rooks").create("rooks");
		
		Option bishop = OptionBuilder.hasArg().withArgName("bishops")
				.withDescription("Number of bishops").create("bishops");
		
		Option queen = OptionBuilder.hasArg().withArgName("queens")
				.withDescription("Number of queens").create("queens");
		
		Option king = OptionBuilder.hasArg().withArgName("kings")
				.withDescription("Number of kings").create("kings");
		
		Option parallel = OptionBuilder.hasArg().withArgName("parallel")
				.withDescription("Parallel mode (experimental). 1 ==> activated, any other number ==> deactivated").create("parallel");
		
		
		Option help = new Option("help",  "Chess solver command line interface. Rows and "
										+ "columns parameter are mandatory. The number of "
										+ "knights, rooks, bishops, queens and kings are "
										+ "optional, but at least one of them must be provided "
										+ "in order to obtain results with sense.");

		options.addOption(rows);
		options.addOption(columns);
		options.addOption(knight);
		options.addOption(rook);
		options.addOption(bishop);
		options.addOption(queen);
		options.addOption(king);
		options.addOption(parallel);
		options.addOption(help);

		CommandLineParser parser = new BasicParser();
		try {
			CommandLine line = parser.parse(options, args);

			if (line.hasOption("help")) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("help text", options);
			} else {
				BasicCommandLineInterface bcli = new BasicCommandLineInterface();
				
				int rowsNumber = ParseUtil.parseNaturalNumber(line.getOptionValue("rows"));
				int columnsNumber = ParseUtil.parseNaturalNumber(line.getOptionValue("columns"));
				int knightNumber = ParseUtil.parseNaturalNumber(line.getOptionValue("knights"));
				int rookNumber = ParseUtil.parseNaturalNumber(line.getOptionValue("rooks"));
				int bishopNumber = ParseUtil.parseNaturalNumber(line.getOptionValue("bishops"));
				int queenNumber = ParseUtil.parseNaturalNumber(line.getOptionValue("queens"));
				int kingNumber = ParseUtil.parseNaturalNumber(line.getOptionValue("kings"));
				int parallelMode = ParseUtil.parseNaturalNumber(line.getOptionValue("parallel"));
				
				
				
				if (rowsNumber > 0 && columnsNumber > 0) {
					result = bcli.solveChessProblem(	rowsNumber, columnsNumber, knightNumber,
											rookNumber, bishopNumber,
											queenNumber, kingNumber, 
											parallelMode);
				} else {
					System.out.println("Parameter not declared. Board sizes are mandatory. Use -help for more info.");
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