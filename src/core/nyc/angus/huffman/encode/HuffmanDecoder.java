package nyc.angus.huffman.encode;

import nyc.angus.huffman.sort.CharEntry;

/**
 * Decodes streams off huffman encoded characters.
 */
public class HuffmanDecoder {
	private final CharEntry root;

	public HuffmanDecoder(final CharEntry root) {
		this.root = root;
	}

	public String decode(final String encodedMessage) {
		final StringBuilder message = new StringBuilder();

		CharEntry element = root;

		for (final char c : encodedMessage.toCharArray()) {

			if (c == '0') {
				element = element.getLeftChild();
			} else if (c == '1') {
				element = element.getRightChild();
			}

			if (element.getLeftChild() == null && element.getRightChild() == null) {
				message.append(element.getChar());
				element = root;
			}
		}

		return message.toString();
	}
}
