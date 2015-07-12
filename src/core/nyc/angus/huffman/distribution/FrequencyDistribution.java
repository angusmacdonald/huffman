package nyc.angus.huffman.distribution;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Utility for calculating the frequency distribution of characters in a string.
 */
public class FrequencyDistribution {

	public FrequencyDistribution() {
		// Default constructor.
	}

	public Map<Character, Double> calculateFrequency(final String string) {
		if (string == null || string.isEmpty()) {
			return Collections.emptyMap();
		}

		final Multiset<Character> occurrences = countOccurencesFromStream(string.chars());

		return calculateFrequency(string, occurrences);
	}

	private Multiset<Character> countOccurencesFromStream(final IntStream charStream) {
		final Multiset<Character> occurrences = HashMultiset.<Character> create();

		charStream.sequential()//
				.forEach(c -> occurrences.add((char) c));

		return occurrences;
	}

	private Map<Character, Double> calculateFrequency(final String string, final Multiset<Character> occurrences) {
		final Map<Character, Double> distribution = new HashMap<>();

		occurrences.stream()//
				.forEach(c -> distribution.put(c, occurrences.count(c) / Double.valueOf(string.length())));

		return distribution;
	}

}
