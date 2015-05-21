package nyc.angus.huffman.sort;

/**
 * Comparable entry representing a character and the frequency with which it appears.
 * <p>
 * The comparable is sorted increasing.
 */
public class CharEntry implements Comparable<CharEntry> {
	private final Character c;
	private final Double frequency;

	private CharEntry leftChild;
	private CharEntry rightChild;

	public CharEntry(final Character c, final Double frequency) {
		this.c = c;
		this.frequency = frequency;
	}

	public CharEntry(final CharEntry leftChild, final CharEntry rightChild, final Double frequency) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.frequency = frequency;
		this.c = null;
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

	public CharEntry getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(final CharEntry leftChild) {
		this.leftChild = leftChild;
	}

	public CharEntry getRightChild() {
		return rightChild;
	}

	public void setRightChild(final CharEntry rightChild) {
		this.rightChild = rightChild;
	}

	public Double getFrequency() {
		return frequency;
	}
}