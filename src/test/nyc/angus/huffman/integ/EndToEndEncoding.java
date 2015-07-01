package nyc.angus.huffman.integ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import nyc.angus.huffman.EncodingResult;
import nyc.angus.huffman.HuffmanEncoder;
import nyc.angus.huffman.HuffmanEncoderFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests of {@link HuffmanEncoder}.
 */
public class EndToEndEncoding {

	private HuffmanEncoder encoder;

	@Before
	public void setUp() {
		encoder = HuffmanEncoderFactory.createEncoder();
	}

	@Test
	public void emptyString() {
		assertDecodingMatchesEncoding("");
	}

	@Test
	public void word() {
		assertDecodingMatchesEncoding("Angus");
	}

	@Test
	public void sentence() {
		assertDecodingMatchesEncoding("This is a type text loop.");
	}

	@Test
	public void oneHundredCharacters() {
		assertDecodingMatchesEncoding(RandomStringUtils.random(100));
	}

	@Test
	public void tenThousandCharacters() {
		assertDecodingMatchesEncoding(RandomStringUtils.random(10000));
	}

	@Test
	public void oneMillionCharacters() {
		assertDecodingMatchesEncoding(RandomStringUtils.random(1000000));
	}

	@Test
	public void testConstructorIsPrivate() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
			InstantiationException {
		final Constructor<HuffmanEncoderFactory> constructor = HuffmanEncoderFactory.class.getDeclaredConstructor();
		assertTrue(Modifier.isPrivate(constructor.getModifiers()));
		constructor.setAccessible(true);
		constructor.newInstance();
	}

	private void assertDecodingMatchesEncoding(final String messageToEncode) {
		final EncodingResult result = encoder.encode(messageToEncode);

		final String decodedMessage = result.getDecoder().decode(result.getMessage(), result.getLengthOfMessage());

		assertEquals(messageToEncode, decodedMessage);
	}

}
