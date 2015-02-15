package com.mm.cs.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.mm.cs.logic.impl.ChessSolverLogicImpl;

public class ChessSolverLogicTest {

	@Test
	public void threeSquaresTwoKingsOneRookTest(){
		ChessSolverLogic csl = new ChessSolverLogicImpl();
		Set<String> configs = csl.solveChessBoard(3, 3, 0, 1, 0, 0, 2);
		assertEquals(4, configs.size());
		
		
		String config = 
				"K o K " +
				"o o o " +
				"o R o ";
		assertTrue(configs.contains(config));
		
		config = 
				"K o o " +
				"o o R " +
				"K o o ";
		assertTrue(configs.contains(config));
		
		config =
				"o o K " +
				"R o o " +
				"o o K ";
		assertTrue(configs.contains(config));
		
		config = 
				"o R o " +
				"o o o " +
				"k o K ";
	}
	
	@Test
	public void fourSquaresTwoRooksFourKnightsTest(){
		ChessSolverLogic csl = new ChessSolverLogicImpl();
		Set<String> configs = csl.solveChessBoard(4, 4, 4, 2, 0, 0, 0);
		assertEquals(8, configs.size());
		
		String config = 
				"o N o N " +
				"o o R o " +
				"o N o N " +
				"R o o o ";
		assertTrue(configs.contains(config));
		
		config = 
				"o N o N " +
				"R o o o " +
				"o N o N " +
				"o o R o ";
		assertTrue(configs.contains(config));
		
		config =
				"R o o o " +
				"o N o N " +
				"o o R o " +
				"o N o N ";
		assertTrue(configs.contains(config));
		
		config =
				"o o R o " +
				"o N o N " +
				"R o o o " +
				"o N o N ";
		assertTrue(configs.contains(config));
		
		config =
				"o R o o " +
				"N o N o " +
				"o o o R " +
				"N o N o ";
		assertTrue(configs.contains(config));
		
		config =
				"o o o R " +
				"N o N o " +
				"o R o o " +
				"N o N o ";
		assertTrue(configs.contains(config));
		
		config =
				"N o N o " +
				"o o o R " +
				"N o N o " +
				"o R o o ";
		assertTrue(configs.contains(config));
		
		config =
				"N o N o " +
				"o R o o " +
				"N o N o " +
				"o o o R ";
	}
}
