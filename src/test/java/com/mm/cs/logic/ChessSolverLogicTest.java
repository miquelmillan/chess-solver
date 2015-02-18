package com.mm.cs.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.mm.cs.logic.concurrent.impl.ChessSolverLogicConcurrentImpl;
import com.mm.cs.logic.impl.ChessSolverLogicImpl;

public class ChessSolverLogicTest {

	@Test
	public void threeSquaresTwoKingsOneRookTest(){
		ChessSolverLogic csl = new ChessSolverLogicConcurrentImpl();
		Set<String> configs = csl.solveChessBoard(3, 3, 0, 1, 0, 0, 2);
		assertEquals(4, configs.size());
		
		String config = 
				"K o K \n" +
				"o o o \n" +
				"o R o \n";
		
		assertTrue(configs.contains(config));
		
		config = 
				"K o o \n" +
				"o o R \n" +
				"K o o \n";
		assertTrue(configs.contains(config));
		
		config =
				"o o K \n" +
				"R o o \n" +
				"o o K \n";
		assertTrue(configs.contains(config));
		
		config = 
				"o R o \n" +
				"o o o \n" +
				"K o K \n";
		assertTrue(configs.contains(config));
	}
	
	@Test
	public void fourSquaresTwoRooksFourKnightsTest(){
		ChessSolverLogic csl = new ChessSolverLogicImpl();
		Set<String> configs = csl.solveChessBoard(4, 4, 4, 2, 0, 0, 0);
		assertEquals(8, configs.size());
		
		String config = 
				"o N o N \n" +
				"o o R o \n" +
				"o N o N \n" +
				"R o o o \n";
		assertTrue(configs.contains(config));
		
		config = 
				"o N o N \n" +
				"R o o o \n" +
				"o N o N \n" +
				"o o R o \n";
		assertTrue(configs.contains(config));
		
		config =
				"R o o o \n" +
				"o N o N \n" +
				"o o R o \n" +
				"o N o N \n";
		assertTrue(configs.contains(config));
		
		config =
				"o o R o \n" +
				"o N o N \n" +
				"R o o o \n" +
				"o N o N \n";
		assertTrue(configs.contains(config));
		
		config =
				"o R o o \n" +
				"N o N o \n" +
				"o o o R \n" +
				"N o N o \n";
		assertTrue(configs.contains(config));
		
		config =
				"o o o R \n" +
				"N o N o \n" +
				"o R o o \n" +
				"N o N o \n";
		assertTrue(configs.contains(config));
		
		config =
				"N o N o \n" +
				"o o o R \n" +
				"N o N o \n" +
				"o R o o \n";
		assertTrue(configs.contains(config));
		
		config =
				"N o N o \n" +
				"o R o o \n" +
				"N o N o \n" +
				"o o o R \n";
		assertTrue(configs.contains(config));
	}
	@Test
	public void singleThreadVsConcurrentThreadSimpleTest(){
		
		long time = System.currentTimeMillis();
		ChessSolverLogic csl = new ChessSolverLogicImpl();
		Set<String> configs = csl.solveChessBoard(4, 3, 0, 1, 0, 0, 2);
		System.out.println("Time (ms): " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		ChessSolverLogic cslConcurent = new ChessSolverLogicConcurrentImpl();
		Set<String> configsConcurrent = cslConcurent.solveChessBoard(4, 3, 0, 1, 0, 0, 2);
		System.out.println("Time (ms): " + (System.currentTimeMillis() - time));
		
		
		assertEquals(configs.size(), configsConcurrent.size());
	}
	
	@Test
	public void singleThreadVsConcurrentThreadComplexTest(){
		
		long time = System.currentTimeMillis();
		ChessSolverLogic csl = new ChessSolverLogicImpl();
		Set<String> configs = csl.solveChessBoard(4, 4, 4, 2, 0, 0, 0);
		System.out.println("Time (ms): " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		ChessSolverLogic cslConcurent = new ChessSolverLogicConcurrentImpl();
		Set<String> configsConcurrent = cslConcurent.solveChessBoard(4, 4, 4, 2, 0, 0, 0);
		System.out.println("Time (ms): " + (System.currentTimeMillis() - time));
		
		
		assertEquals(configs.size(), configsConcurrent.size());
	}

}
