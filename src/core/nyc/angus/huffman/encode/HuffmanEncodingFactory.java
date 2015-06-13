package nyc.angus.huffman.encode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import nyc.angus.huffman.sort.CharEntry;

public class HuffmanEncodingFactory {

	/**
	 * Return a map of characters to the code that should be used for the character.
	 * 
	 * @param queue
	 *        Characters ordered by the frequency with which they occur.
	 * @return Mapping from character to its encoding.
	 */
	public static Map<Character, String> createEncodings(final PriorityQueue<CharEntry> queue) {

		final CharEntry root = createTree(queue);

		final Map<Character, String> codes = new HashMap<>();

		traverseTreeAndStoreHuffmanCodes("", codes, root);

		return codes;
	}

	/**
	 * Create encoding tree that can be used to generate huffman codes.
	 */
	public static CharEntry createTree(final PriorityQueue<CharEntry> queue) {
		while (queue.size() > 1) {
			final CharEntry a = queue.poll();
			final CharEntry b = queue.poll();

			final CharEntry parent = new CharEntry(a, b, a.getFrequency() + b.getFrequency());
			queue.add(parent);
		}

		assert queue.size() == 1;

		return queue.poll();
	}

	/**
	 * Recursively traverse the encoding tree and update <tt>codes</tt> with the character and its encoding (based on
	 * this traversal).
	 */
	private static void traverseTreeAndStoreHuffmanCodes(final String string, final Map<Character, String> codes, final CharEntry entry) {
		if (entry == null) {
			return;
		}

		if (entry.getChar() != null) {
			codes.put(entry.getChar(), string);
		} else {
			traverseTreeAndStoreHuffmanCodes(string + "0", codes, entry.getLeftChild());
			traverseTreeAndStoreHuffmanCodes(string + "1", codes, entry.getRightChild());
		}
	}

}
