package nyc.angus.huffman.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanEncodingFactory {

	public static Map<Character, String> create(final PriorityQueue<CharEntry> queue) {

		while (queue.size() > 1) {
			final CharEntry a = queue.poll();
			final CharEntry b = queue.poll();

			final CharEntry parent = new CharEntry(a, b, a.getFrequency() + b.getFrequency());
			queue.add(parent);
		}

		assert queue.size() == 1;

		final Map<Character, String> codes = new HashMap<>();

		traverse("", codes, queue.poll());

		return codes;
	}

	private static void traverse(final String string, final Map<Character, String> codes, final CharEntry entry) {
		if (entry.getChar() != null) {
			codes.put(entry.getChar(), string);
		} else {
			traverse(string + "0", codes, entry.getLeftChild());
			traverse(string + "1", codes, entry.getRightChild());
		}
	}

}
