package nyc.angus.huffman.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import nyc.angus.huffman.sort.CharEntry;
import nyc.angus.huffman.sort.FrequencySorter;

import org.junit.Test;

/**
 * Tests of {@link FrequencySorter}.
 */
public class FrequencySorterTest {

	@Test
	public void basicSort() {
		final FrequencySorter sorter = new FrequencySorter();

		final Map<Character, Double> frequencies = new HashMap<>();
		frequencies.put('a', 0.5);
		frequencies.put('b', 0.25);

		final PriorityQueue<CharEntry> result = sorter.generateFrequencyTree(frequencies);

		assertEquals(new Character('b'), result.poll().getChar());
		assertEquals(new Character('a'), result.poll().getChar());
	}

	@Test
	public void emptyInput() {
		final FrequencySorter sorter = new FrequencySorter();

		final Map<Character, Double> frequencies = new HashMap<>();
		frequencies.put('a', 0.5);
		frequencies.put('b', 0.25);

		final PriorityQueue<CharEntry> result = sorter.generateFrequencyTree(frequencies);

		assertNotNull(result);
	}
}
