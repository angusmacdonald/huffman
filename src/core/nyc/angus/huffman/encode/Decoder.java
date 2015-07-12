package nyc.angus.huffman.encode;

import java.util.BitSet;

import nyc.angus.huffman.sort.CharEntry;

/**
 * Decodes streams off huffman encoded characters.
 */
public class Decoder {
	private final CharEntry root;

	public Decoder(final CharEntry root) {
		this.root = root;
	}

	public String decode(final byte[] message, final int totalLength) {
		if (totalLength == 0) {
			return "";
		}

		final StringBuilder result = new StringBuilder();

		final BitSet encoded = BitSet.valueOf(message);

		CharEntry treeEl = root;

		int lengthParsed = 0;

		for (int i = 0; i < totalLength; i++) {

			final long val = encoded.get(i) ? 1l : 0l;

			treeEl = traverseEncodingTree(result, treeEl, val);

			if (++lengthParsed == totalLength) {
				return result.toString();
			}
		}

		return null;
	}

	private CharEntry traverseEncodingTree(final StringBuilder result, CharEntry treeEl, final long val) {
		if (val == 0) {
			treeEl = treeEl.getLeftChild();
		} else if (val == 1) {
			treeEl = treeEl.getRightChild();
		}

		if (treeEl.getLeftChild() == null && treeEl.getRightChild() == null) {
			result.append(treeEl.getChar());
			treeEl = root;
		}

		return treeEl;
	}
}
