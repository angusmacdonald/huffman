package nyc.angus.huffman.sort;

/**
 * Comparable entry representing a character and the frequency with which it appears.
 * <p>
 * The comparable is sorted increasing.
 */
public class CharEntry implements Comparable<CharEntry> {
	private final Character c;
	private final Double frequency;

	public CharEntry(final Character c, final Double frequency) {
		this.c = c;
		this.frequency = frequency;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(final CharEntry o) {
		final double value = this.frequency - o.frequency;
		return value > 0 ? 1 : value < 0 ? -1 : 0;
	}

	public Character getChar() {
		return c;
	}
}