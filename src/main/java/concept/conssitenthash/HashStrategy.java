package concept.conssitenthash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import concept.conssitenthash.strategy.IStrategy;

/**
 * 
 * @author Mahesh
 *
 */
public class HashStrategy implements IStrategy {

	private MessageDigest instance;

	public static HashStrategy getAlgorithm(String algorithmName) {

		return new HashStrategy(algorithmName);
	}

	private HashStrategy(String algorithmName) {
		try {
			instance = MessageDigest.getInstance(algorithmName);
		} catch (NoSuchAlgorithmException e) {
			// doesn't matter
			throw new AssertionError(e);
		}
	}

	public long hash(String key) {

		instance.reset();

		instance.update(key.getBytes());

		byte[] digest = instance.digest();

		long h = 0;

		for (int i = 0; i < 4; i++) {

			h <<= 8;

			h |= ((int) digest[i]) & 0xFF;
		}
		return h;
	}
}