package nyc.angus.huffman;

import nyc.angus.huffman.encode.Decoder;

/**
 * Result of encoding a message. Returns the encoded message and the decoder which can later be used to decode it.
 */
public class EncodingResult {

	private final String message;
	private final Decoder decoder;

	public EncodingResult(final String message, final Decoder decoder) {
		this.message = message;
		this.decoder = decoder;
	}

	public String getMessage() {
		return message;
	}

	public Decoder getDecoder() {
		return decoder;
	}

}
