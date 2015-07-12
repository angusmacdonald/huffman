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

import nyc.angus.huffman.encode.Encoder;
import nyc.angus.huffman.encode.EncoderFactory;
import nyc.angus.huffman.sort.CharEntry;
import nyc.angus.huffman.sort.FrequencySorter;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of {@link EncoderFactory}.
 */
public class HuffmanEncoderTests {

	private final Map<Character, Double> frequencies = new HashMap<>();

	private Encoder encoder;

	@Before
	public void setUp() {
		frequencies.put('a', 0.5);
		frequencies.put('b', 0.25);
		frequencies.put('c', 0.25);

		final FrequencySorter sorter = new FrequencySorter();

		final PriorityQueue<CharEntry> result = sorter.generateFrequencyTree(frequencies);

		final Map<Character, String> encoding = EncoderFactory.createEncodings(result);

		encoder = new Encoder(encoding);
	}

	@Test
	public void encodeThree() {
		assertTrue(encoder.encode("a").getLeft() < encoder.encode("b").getLeft());
	}

	@Test
	public void emptyString() {
		assertEquals(new Integer(0), encoder.encode("").getLeft());
	}

	@Test
	public void testConstructorIsPrivate() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
			InstantiationException {
		final Constructor<EncoderFactory> constructor = EncoderFactory.class.getDeclaredConstructor();
		assertTrue(Modifier.isPrivate(constructor.getModifiers()));
		constructor.setAccessible(true);
		constructor.newInstance();
	}
}
