package com.massimo.minimal_path;

import java.io.IOException;

public class MinTrianglePath {
	
	public static void main(String[] args) throws IOException {
		
		Triangle triangle = new Triangle();
		StreamReader streamReader = new StreamReader(System.in);
		
		try {
			
			// reads triangle lines for standard input and adds them to the triangle object one at the time
			int[] nextRow;
			while ((nextRow = streamReader.getNextRow()) != null) {
				triangle.addRow(nextRow);
			}
			
			// evaluates the minimum path
			Path path = triangle.getMinimalPath();
			
			System.out.println(path);
		
		} catch(IllegalArgumentException e) {
			System.out.println("please type in numbers separated by spaces");
		} catch(UnsupportedOperationException e) {
			System.out.println("please type in numbers separated by spaces");
		}
		
	}

}
