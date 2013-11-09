package com.massimo.minimal_path;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.massimo.minimal_path.StreamReader;

public class StreamReaderTest {
	
	@Test
	public void getNextRowShouldReturnTheNextRow() throws IOException {
		String input = "1\n2 3";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		StreamReader streamReader = new StreamReader(inputStream);
		assertArrayEquals(new int[]{ 1 }, streamReader.getNextRow());
		assertArrayEquals(new int[]{ 2, 3 }, streamReader.getNextRow());
		assertNull(streamReader.getNextRow());
	}
	
	@Test
	public void getNextRowShouldCopeWithExtraSpaces() throws IOException {
		String input = " 1   \n   2  3   ";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		StreamReader streamReader = new StreamReader(inputStream);
		assertArrayEquals(new int[]{ 1 }, streamReader.getNextRow());
		assertArrayEquals(new int[]{ 2, 3 }, streamReader.getNextRow());
		assertNull(streamReader.getNextRow());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getNextRowShouldReturnAnExceptionForMalformedData() throws IOException {
		String input = "a";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		StreamReader streamReader = new StreamReader(inputStream);
		streamReader.getNextRow();
		fail();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getNextRowShouldReturnAnExceptionForASpacedString() throws IOException {
		String input = " ";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		StreamReader streamReader = new StreamReader(inputStream);
		streamReader.getNextRow();
		assertNull(streamReader.getNextRow());
	}

}
