package nyc.angus.huffman.test;

import static org.junit.Assert.assertEquals;
import nyc.angus.huffman.sort.CharEntry;

import org.junit.Test;

/**
 * Tests of {@link CharEntry}.
 */
public class CharEntryTests {

	@Test
	public void compareEquals() {
		final CharEntry a = new CharEntry('a', 1.0);
		final CharEntry b = new CharEntry('b', 1.0);

		assertEquals(0, a.compareTo(b));
	}

	@Test
	public void compareAGreater() {
		final CharEntry a = new CharEntry('a', 1.0);
		final CharEntry b = new CharEntry('b', 0.5);

		assertEquals(1, a.compareTo(b));
	}

	@Test
	public void compareALess() {
		final CharEntry a = new CharEntry('a', 1.0);
		final CharEntry b = new CharEntry('b', 1.5);

		assertEquals(-1, a.compareTo(b));
	}
}
