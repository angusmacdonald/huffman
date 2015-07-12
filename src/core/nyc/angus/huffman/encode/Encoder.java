package nyc.angus.huffman.encode;

import java.util.BitSet;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

public class Encoder {

	static final int SIZE = Long.SIZE / 2;

	private final Map<Character, String> codes;

	public Encoder(final Map<Character, String> codes) {
		this.codes = codes;
	}

	public Pair<Integer, byte[]> encode(final String str) {

		final BitSet encoded = new BitSet();

		int pos = 0;

		for (int i = 0; i < str.length(); i++) {

			final String code = codes.get(str.charAt(i));

			for (final char c : code.toCharArray()) {
				encoded.set(pos++, c == '1');
			}
		}

		return Pair.of(pos, encoded.toByteArray());
	}
}
