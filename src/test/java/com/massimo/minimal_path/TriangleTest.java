package com.massimo.minimal_path;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.massimo.minimal_path.Path;
import com.massimo.minimal_path.Triangle;

public class TriangleTest {
	
	private Triangle iut;
	
	@Before
	public void setUp() {
		iut = new Triangle();
	}
	
	@Test
	public void addRowShouldThrowAnErrorWhenTryingToAddAWrongNumberOfNodes() {
		try {
			iut.addRow(new int[] { 1, 2 });
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Wrong array size: it should be of 1 elements, but it was of 2 elements.", e.getMessage());
		}
	}
	
	@Test
	public void getMinimalPathShouldReturnAPathWithTheTopNodeWhenTriangleHasOneNodeOnly() {
		int topNode = 5;
		iut.addRow(new int[]{ topNode });
		Path expectedPath = new Path();
		expectedPath.addFirst(topNode);
		assertEquals(expectedPath, iut.getMinimalPath());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void getMinimalPathShouldReturnAnExceptionIfTheTriangleIsEmpty() {
		iut.getMinimalPath();
	}
	
	@Test
	public void getMinimalPathShouldReturnCorrectPathForSmallTriangle() {
		iut.addRow(new int[]{ 1 });
		iut.addRow(new int[]{ 3, 2 });
		Path expectedPath = new Path();
		expectedPath.addFirst(2);
		expectedPath.addFirst(1);
		assertEquals(expectedPath, iut.getMinimalPath());
	}
	
	@Test
	public void getMinimalPathShouldReturnCorrectPathForBiggerTriangle() {
		iut.addRow(new int[]{ 7 });
		iut.addRow(new int[]{ 6, 3 });
		iut.addRow(new int[]{ 3, 8, 5 });
		iut.addRow(new int[]{ 11, 2, 10, 9 });
		assertEquals("Minimal path is: 7 + 6 + 3 + 2 = 18", iut.getMinimalPath().toString());
	}

}
