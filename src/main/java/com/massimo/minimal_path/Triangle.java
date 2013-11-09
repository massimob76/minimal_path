package com.massimo.minimal_path;

import java.util.LinkedList;


public class Triangle {
	
	private final LinkedList<int[]> nodesRows = new LinkedList<int[]>();
	
	public void addRow(int[] nodesRow) {
		verify(nodesRow);
		nodesRows.add(nodesRow);
	}
	
	public Path getMinimalPath() {
		
		if (nodesRows.isEmpty()) throw new UnsupportedOperationException("cannot calculate minimal path of empty triangle");

		int[] nodesRow;
		
		// creates a list of potential paths
		Paths paths = new Paths();
		
		// initializes the paths with the last row of the triangle
		paths.addNodes(nodesRows.pollLast());
		
		while ((nodesRow = nodesRows.pollLast()) != null) {
			
			// filters out paths which are not candidate to be the minimum path
			paths.reduceByMin();
			
			// adds another row of nodes to the potential paths
			paths.addNodes(nodesRow);
		}
		
		// since reduceByMin decrements the number of paths by one, once we have polled all the rows of the triangle
		// we should have only one remaining path
		return paths.getFirst();
		
	}
	
	private void verify(int[] nodesRow) {
		if (nodesRow.length != nodesRows.size() + 1) {
			throw new IllegalArgumentException("Wrong array size: it should be of " 
				+ (nodesRows.size() + 1) + " elements, but it was of " + nodesRow.length + " elements.");
		}
	}

}
