package nyc.angus.huffman;

import java.util.Map;
import java.util.PriorityQueue;

import nyc.angus.huffman.distribution.FrequencyDistribution;
import nyc.angus.huffman.encode.Decoder;
import nyc.angus.huffman.encode.Encoder;
import nyc.angus.huffman.encode.EncoderFactory;
import nyc.angus.huffman.sort.CharEntry;
import nyc.angus.huffman.sort.FrequencySorter;

/**
 * Main class for encoding messages with the huffman encoder. Set up with the {@link HuffmanEncoderFactory} utility.
 */
public class HuffmanEncoder {

	private final FrequencyDistribution dist;
	private final FrequencySorter sorter;

	protected HuffmanEncoder(final FrequencyDistribution dist, final FrequencySorter sorter) {
		this.dist = dist;
		this.sorter = sorter;
	}

	public EncodingResult encode(final String message) {
		final Map<Character, Double> frequencies = dist.calculateFrequency(message);

		final PriorityQueue<CharEntry> result = sorter.generateFrequencyTree(frequencies);

		final Map<Character, String> encoding = EncoderFactory.createEncodings(new PriorityQueue<CharEntry>(result));

		final Encoder encoder = new Encoder(encoding);
		final Decoder decoder = new Decoder(EncoderFactory.createTree(new PriorityQueue<CharEntry>(result)));

		return new EncodingResult(encoder.encode(message), decoder);
	}
}
