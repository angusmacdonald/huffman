package nyc.angus.huffman.sort;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

/**
 * Utility for sorting character frequencies in increasing order of occurrence.
 */
public class FrequencySorter {

	public FrequencySorter() {
		// Default constructor.
	}

	public PriorityQueue<CharEntry> generateFrequencyTree(@Nonnull final Map<Character, Double> frequencies) {
		final Set<CharEntry> asCharEntry = frequencies.entrySet().stream() //
				.map(e -> new CharEntry(e.getKey(), e.getValue())) //
				.collect(Collectors.toSet());

		return new PriorityQueue<>(asCharEntry);
	}

}
