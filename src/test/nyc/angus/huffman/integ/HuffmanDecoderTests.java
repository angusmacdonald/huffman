package nyc.angus.huffman.integ;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.PriorityQueue;

import nyc.angus.huffman.distribution.FrequencyDistribution;
import nyc.angus.huffman.encode.HuffmanDecoder;
import nyc.angus.huffman.encode.HuffmanEncoder;
import nyc.angus.huffman.encode.HuffmanEncodingFactory;
import nyc.angus.huffman.sort.CharEntry;
import nyc.angus.huffman.sort.FrequencySorter;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * Tests of {@link HuffmanDecoder}.
 */
public class HuffmanDecoderTests {

	private HuffmanEncoder encoder;

	private HuffmanDecoder decoder;

	@Test
	public void word() {
		assertDecodingMatchesEncoding("Angus");
	}

	@Test
	public void sentence() {
		assertDecodingMatchesEncoding("This is a type text loop.");
	}

	@Test
	public void oneHundredCharacters() {
		assertDecodingMatchesEncoding(RandomStringUtils.random(100));
	}

	@Test
	public void tenThousandCharacters() {
		assertDecodingMatchesEncoding(RandomStringUtils.random(10000));
	}

	@Test
	public void oneMillionCharacters() {
		assertDecodingMatchesEncoding(RandomStringUtils.random(1000000));
	}

	@Test
	public void emptyString() {
		assertDecodingMatchesEncoding("");
	}

	private void assertDecodingMatchesEncoding(final String messageToEncode) {
		createEncoderAndDecoder(messageToEncode);

		final String encodedMessage = encoder.encode(messageToEncode);
		final String decodedMessage = decoder.decode(encodedMessage);

		assertEquals(messageToEncode, decodedMessage);
	}

	private void createEncoderAndDecoder(final String messageToEncode) {
		final FrequencyDistribution dist = new FrequencyDistribution();

		final Map<Character, Double> frequencies = dist.calculateFrequency(messageToEncode);

		final FrequencySorter sorter = new FrequencySorter();

		final PriorityQueue<CharEntry> result = sorter.generateFrequencyTree(frequencies);

		final Map<Character, String> encoding = HuffmanEncodingFactory.createEncodings(new PriorityQueue<CharEntry>(result));

		encoder = new HuffmanEncoder(encoding);
		decoder = new HuffmanDecoder(HuffmanEncodingFactory.createTree(new PriorityQueue<CharEntry>(result)));
	}

}
