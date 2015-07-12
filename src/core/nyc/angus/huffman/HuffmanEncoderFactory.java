package nyc.angus.huffman;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Factory for creating an instance of {@link HuffmanEncoder}.
 */
public class HuffmanEncoderFactory {

	private HuffmanEncoderFactory() {
		// Should not be instantiated.
	}

	@Singleton
	@Component(modules = { FrequencyDistributionModule.class })
	public interface EncoderBuilder {
		HuffmanEncoder make();
	}

	public static HuffmanEncoder createEncoder() {
		return DaggerHuffmanEncoderFactory_EncoderBuilder.builder().build().make();
	}
}
