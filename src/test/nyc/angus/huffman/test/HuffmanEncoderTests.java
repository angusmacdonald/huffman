/*
 * Copyright 2015, Angus Macdonald 
 */

package nyc.angus.huffman.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import nyc.angus.huffman.encode.HuffmanEncoder;
import nyc.angus.huffman.encode.HuffmanEncodingFactory;
import nyc.angus.huffman.sort.CharEntry;
import nyc.angus.huffman.sort.FrequencySorter;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of {@link HuffmanEncodingFactory}.
 */
public class HuffmanEncoderTests {

	private final Map<Character, Double> frequencies = new HashMap<>();

	private HuffmanEncoder encoder;

	@Before
	public void setUp() {
		frequencies.put('a', 0.5);
		frequencies.put('b', 0.25);
		frequencies.put('c', 0.25);

		final FrequencySorter sorter = new FrequencySorter();

		final PriorityQueue<CharEntry> result = sorter.generateFrequencyTree(frequencies);

		final Map<Character, String> encoding = HuffmanEncodingFactory.createEncodings(result);

		encoder = new HuffmanEncoder(encoding);
	}

	@Test
	public void encodeThree() {
		assertTrue(encoder.encode("a").length() < encoder.encode("b").length());
	}

	@Test
	public void emptyString() {
		assertEquals("", encoder.encode(""));
	}

	@Test
	public void testConstructorIsPrivate() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
			InstantiationException {
		final Constructor<HuffmanEncodingFactory> constructor = HuffmanEncodingFactory.class.getDeclaredConstructor();
		assertTrue(Modifier.isPrivate(constructor.getModifiers()));
		constructor.setAccessible(true);
		constructor.newInstance();
	}
}
