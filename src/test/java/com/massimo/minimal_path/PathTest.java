package com.massimo.minimal_path;

import static org.junit.Assert.*;

import org.junit.Test;

import com.massimo.minimal_path.Path;

public class PathTest {
	
	@Test
	public void twoPathInstancesCanBeCompared() {
		Path pathA = new Path();
		Path pathB = new Path();
		pathA.addFirst(1);
		pathB.addFirst(2);
		assertTrue(pathA.compareTo(pathB) < 0);
		pathA.addFirst(3);
		assertTrue(pathA.compareTo(pathB) > 0);
		pathB.addFirst(2);
		assertTrue(pathA.compareTo(pathB) == 0);
	}
	
	@Test
	public void toStringReturnsACorrectPathWithSum() {
		Path path = new Path();
		path.addFirst(2);
		path.addFirst(3);
		path.addFirst(6);
		path.addFirst(7);
		assertEquals("Minimal path is: 7 + 6 + 3 + 2 = 18", path.toString());
	}
	
	@Test
	public void equalsShouldReturnTrueWhenPathsAreTheSame() {
		Path pathA = new Path();
		Path pathB = new Path();
		pathA.addFirst(6);
		pathB.addFirst(6);
		assertTrue(pathA.equals(pathB));
	}
	
	@Test
	public void equalsShouldReturnFalseWhenPathsAreDifferent() {
		Path pathA = new Path();
		Path pathB = new Path();
		pathA.addFirst(5);
		pathB.addFirst(6);
		assertFalse(pathA.equals(pathB));
	}
	
	@Test
	public void shouldBeAbleToCreateADeepCopyOfPath() {
		Path pathA = new Path();
		pathA.addFirst(1);
		Path pathB = new Path(pathA);
		pathA.addFirst(2);
		assertEquals("Minimal path is: 2 + 1 = 3", pathA.toString());
		assertEquals("Minimal path is: 1 = 1", pathB.toString());
	}

}
