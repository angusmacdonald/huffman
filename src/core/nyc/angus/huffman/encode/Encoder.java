package nyc.angus.huffman.encode;

import java.util.BitSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class Encoder {

	static final int SIZE = Long.SIZE / 2;

	private final Map<Character, String> codes;

	public Encoder(final Map<Character, String> codes) {
		this.codes = codes;
	}

	public Pair<Integer, byte[]> encode(final String str) {
		final BitSet encoded = new BitSet();
		final AtomicInteger pos = new AtomicInteger(0);

		str.chars().mapToObj(i -> codes.get((char) i))//
				.collect(Collectors.joining()).chars()//
				.forEach(c -> encoded.set(pos.getAndIncrement(), c == '1'));

		return Pair.of(pos.get(), encoded.toByteArray());
	}
}
