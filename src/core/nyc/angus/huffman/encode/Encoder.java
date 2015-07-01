package nyc.angus.huffman.encode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

public class Encoder {

	static final int SIZE = Long.SIZE / 2;

	private final Map<Character, String> codes;

	public Encoder(final Map<Character, String> codes) {
		this.codes = codes;
	}

	public Pair<Integer, List<Long>> encode(final String str) {

		final List<Long> encoded = new LinkedList<>();

		long nextEntry = 0l;

		int messageLength = 0;

		for (int i = 0, posInArrayElement = 0; i < str.length(); i++) {

			final String code = codes.get(str.charAt(i));

			messageLength += code.length();

			for (final char c : code.toCharArray()) {

				if (posInArrayElement >= SIZE) {
					posInArrayElement = 0;
					encoded.add(nextEntry);
					nextEntry = 0l;
				}

				final long val = Character.getNumericValue(c) << posInArrayElement++;

				nextEntry |= val;
			}
		}

		encoded.add(nextEntry);

		return Pair.of(messageLength, encoded);
	}
}
