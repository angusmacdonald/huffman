package nyc.angus.huffman.encode;

import java.util.List;

import nyc.angus.huffman.sort.CharEntry;

/**
 * Decodes streams off huffman encoded characters.
 */
public class Decoder {
	private final CharEntry root;

	public Decoder(final CharEntry root) {
		this.root = root;
	}

	public String decode(final List<Long> encoded, final int totalLength) {
		if (totalLength == 0) {
			return "";
		}

		final StringBuilder result = new StringBuilder();

		CharEntry treeEl = root;

		int lengthParsed = 0;

		for (final long element : encoded) {

			for (int y = 0; y < Encoder.SIZE; y++) {
				final long val = (element >> y) & 1l;

				treeEl = traverseEncodingTree(result, treeEl, val);

				if (++lengthParsed == totalLength) {
					return result.toString();
				}
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
