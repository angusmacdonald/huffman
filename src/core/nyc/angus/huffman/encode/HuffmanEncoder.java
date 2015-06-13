package nyc.angus.huffman.encode;

import java.util.Map;

public class HuffmanEncoder {

	private final Map<Character, String> codes;

	public HuffmanEncoder(final Map<Character, String> codes) {
		this.codes = codes;
	}

	public String encode(final String str) {
		final StringBuffer buf = new StringBuffer();

		for (final Character c : str.toCharArray()) {
			buf.append(codes.get(c));
			buf.append("|");
		}

		return buf.toString();
	}
}
