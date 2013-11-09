package com.massimo.minimal_path;

import java.util.LinkedList;

public class Path implements Comparable<Path> {
	
	private LinkedList<Integer> nodes = new LinkedList<Integer>();
	private int sum = 0;
	
	public Path() {	}
	
	public Path(Path path) {
		this.nodes = new LinkedList<Integer>(path.nodes);
		this.sum = path.sum;
	}

	//adds a node to the beginning of the list of nodes
	public void addFirst(int node) {
		nodes.addFirst(node);
		sum += node;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Minimal path is: ");
		for (int i = 0; i < nodes.size(); i++) {
			sb.append(nodes.get(i));
			if (i != nodes.size() - 1) sb.append(" + ");
		}
		sb.append(" = ");
		sb.append(sum);
		return sb.toString();
	}

	public int compareTo(Path path) {
		return this.sum - path.sum;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Path) {
			Path path = (Path)o;
			return (this.sum == path.sum && this.nodes.equals(path.nodes));
		} else {
			return false;
		}
		
	}
}

