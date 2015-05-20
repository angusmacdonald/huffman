package nyc.angus.huffman.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import nyc.angus.huffman.FrequencyDistribution;

import org.junit.Test;

public class ProbabilityDistributionTest {

	@Test
	public void basicDistribution() {
		final FrequencyDistribution dist = new FrequencyDistribution();

		final String string = "abca";
		final Map<Character, Double> res = dist.calculateFrequency(string);

		assertEquals(0.5, res.get('a'), 0.01);
		assertEquals(0.25, res.get('b'), 0.01);
		assertEquals(0.25, res.get('c'), 0.01);
	}

	@Test
	public void nullString() {
		final FrequencyDistribution dist = new FrequencyDistribution();
		assertTrue(dist.calculateFrequency(null).isEmpty());
	}

	@Test
	public void emptyString() {
		final FrequencyDistribution dist = new FrequencyDistribution();
		assertTrue(dist.calculateFrequency("").isEmpty());
	}

	@Test
	public void allOneCharacter() {
		final FrequencyDistribution dist = new FrequencyDistribution();
		assertEquals(1.0, dist.calculateFrequency("aa").get('a'), 0.01);
	}
}
