package nyc.angus.huffman;

import nyc.angus.huffman.encode.Decoder;

/**
 * Result of encoding a message. Returns the encoded message and the decoder which can later be used to decode it.
 */
public class EncodingResult {

	private final byte[] message;
	private final Decoder decoder;
	private final int lengthOfMessage;

	public EncodingResult(final byte[] message, final int lengthOfMessage, final Decoder decoder) {
		this.message = message;
		this.lengthOfMessage = lengthOfMessage;
		this.decoder = decoder;
	}

	public byte[] getMessage() {
		return message;
	}

	public Decoder getDecoder() {
		return decoder;
	}

	public int getLengthOfMessage() {
		return lengthOfMessage;
	}

}
