package com.massimo.minimal_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamReader {
	
	private final BufferedReader br;
	
	public StreamReader(InputStream inputStream) {
		br = new BufferedReader(new InputStreamReader(inputStream));
	}
	
	public int[] getNextRow() throws IOException {
		try {
			String line = br.readLine();
			if (line == null) {
				br.close();
				return null;
			} else {
				return convertSpaceSeparatedStringToIntArray(line);
			}
		} catch(IOException e) {
			br.close();
			throw e;
		} catch(IllegalArgumentException e) {
			br.close();
			throw e;
		}
	}
	
	private int[] convertSpaceSeparatedStringToIntArray(String string) {
		String[] stringArray = string.trim().split("\\s+");
		int[] array = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			array[i] = Integer.parseInt(stringArray[i]);
		}
		return array;
	}

}
