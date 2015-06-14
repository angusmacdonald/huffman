package nyc.angus.huffman.encode;

import java.util.Map;

public class Encoder {

	private final Map<Character, String> codes;

	public Encoder(final Map<Character, String> codes) {
		this.codes = codes;
	}

	public String encode(final String str) {
		final StringBuffer buf = new StringBuffer();

		str.chars().forEach(i -> buf.append(codes.get((char) i)));

		return buf.toString();
	}
}
