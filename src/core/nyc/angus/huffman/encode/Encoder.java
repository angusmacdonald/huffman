package nyc.angus.huffman.encode;

import java.util.Map;

public class Encoder {

	private final Map<Character, String> codes;

	public Encoder(final Map<Character, String> codes) {
		this.codes = codes;
	}

	public String encode(final String str) {
		final StringBuffer buf = new StringBuffer();

		if (str != null) {
			for (final Character c : str.toCharArray()) {
				buf.append(codes.get(c));
			}
		}

		return buf.toString();
	}
}
