package nyc.angus.huffman;

import nyc.angus.huffman.distribution.FrequencyDistribution;
import nyc.angus.huffman.sort.FrequencySorter;

/**
 * Factory for creating an instance of {@link HuffmanEncoder}.
 */
public class HuffmanEncoderFactory {

	private HuffmanEncoderFactory() {
		// Should not be instantiated.
	}

	public static HuffmanEncoder createEncoder() {
		final FrequencyDistribution dist = new FrequencyDistribution();
		final FrequencySorter sorter = new FrequencySorter();

		return new HuffmanEncoder(dist, sorter);
	}
}
