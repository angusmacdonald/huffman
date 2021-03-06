package nyc.angus.huffman;

import java.util.Map;
import java.util.PriorityQueue;

import javax.inject.Inject;

import nyc.angus.huffman.distribution.FrequencyDistribution;
import nyc.angus.huffman.encode.Decoder;
import nyc.angus.huffman.encode.Encoder;
import nyc.angus.huffman.encode.EncoderFactory;
import nyc.angus.huffman.sort.CharEntry;
import nyc.angus.huffman.sort.FrequencySorter;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Main class for encoding messages with the huffman encoder. Set up with the {@link HuffmanEncoderFactory} utility.
 */
public class HuffmanEncoder {

	private final FrequencyDistribution dist;
	private final FrequencySorter sorter;

	@Inject
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

		final Pair<Integer, byte[]> encodedMessage = encoder.encode(message);
		return new EncodingResult(encodedMessage.getRight(), encodedMessage.getLeft(), decoder);
	}
}
