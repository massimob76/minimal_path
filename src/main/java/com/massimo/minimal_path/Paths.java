package com.massimo.minimal_path;

import java.util.ArrayList;
import java.util.List;

public class Paths {
	
	private List<Path> paths;
	
	List<Path> getPaths() {
		return paths;
	}
	
	public Path getFirst() {
		return paths.get(0);
	}
	
	//initializes the paths list with paths having one node each
	private void initialize(int[] nodes) {
		paths = new ArrayList<Path>();
		for (int node: nodes) {
			Path path = new Path();
			path.addFirst(node);
			paths.add(path);
		}
	}
	
	public void addNodes(int[] nodes) {
		if (paths == null) {
			initialize(nodes);
		} else {
			for (int i = 0; i < nodes.length; i++) {
				Path path = paths.get(i);
				path.addFirst(nodes[i]);
			}
		}
	}
	
	// navigates all the paths list where it compares two adjacent path at the time and promotes only the minimum between the two.
	// The original paths are replaced by the list of promoted ones.
	public void reduceByMin() {
		List<Path> reducedPaths = new ArrayList<Path>();
		for (int i = 1; i < paths.size(); i++) {
			Path pathA = paths.get(i - 1);
			Path pathB = paths.get(i);
			if (pathA.compareTo(pathB) <= 0) {
				reducedPaths.add(pathA);
			} else {
				// during comparison the same path can be promoted twice, therefore a cloned path is promoted
				reducedPaths.add(new Path(pathB));
			}
		}
		paths = reducedPaths;
	}
	
}
