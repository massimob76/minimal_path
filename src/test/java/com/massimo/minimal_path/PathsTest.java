package com.massimo.minimal_path;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.massimo.minimal_path.Path;
import com.massimo.minimal_path.Paths;

public class PathsTest {
	
	@Test
	public void addNodesWorksFine() {
		Paths paths = new Paths();
		paths.addNodes(new int[] { 4 });
		
		Path expected = new Path();
		expected.addFirst(4);
		
		assertEquals(expected, paths.getFirst());
	}
	
	@Test
	public void addNodesWorksFineForMultipleAdditions() {
		Paths paths = new Paths();
		paths.addNodes(new int[] { 4 });
		paths.addNodes(new int[] { 5 });
		
		Path expected = new Path();
		expected.addFirst(4);
		expected.addFirst(5);
		
		assertEquals(expected, paths.getFirst());
	}
	
	@Test
	public void reduceByMinReducesTheNumberOfPathsByOneChoosingTheMinimumAndCloningDuplicates() {
		Paths paths = new Paths();
		paths.addNodes(new int[] { 3, 2, 5} );
		
		paths.reduceByMin();
		List<Path> pathsList = paths.getPaths();
		
		assertEquals(2, pathsList.size());
		
		Path expectedPath = new Path();
		expectedPath.addFirst(2);
		
		assertEquals(expectedPath, pathsList.get(0));
		assertEquals(pathsList.get(0), pathsList.get(1));
		assertFalse(pathsList.get(0) == pathsList.get(1));
	}

}
