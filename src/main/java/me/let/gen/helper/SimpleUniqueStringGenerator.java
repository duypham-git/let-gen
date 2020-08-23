package me.let.gen.helper;

import java.security.SecureRandom;

/**
 * it's simple and probably enough
 */
public class SimpleUniqueStringGenerator implements IUniqueStringGenerator {
    private static final String CHAR_LC = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_POOL = CHAR_LC + CHAR_LC.toUpperCase();
    private final SecureRandom secureRandom;

    public SimpleUniqueStringGenerator() {
        this.secureRandom = new SecureRandom();
    }

    public SimpleUniqueStringGenerator(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
    }

    /**
     * generate string which contain random characters from CHAR_POOL with provided
     * length
     * 
     * @param length
     * @return a String of random characters
     */
    @Override
    public String generate(final int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length must be >= 1");
        }

        // randomize index from (0 to CHAR_POOL.length) and get corresponding char.
        // append char to builder until input length reached.
        // profit.
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            final int rIndex = secureRandom.nextInt(CHAR_POOL.length());
            builder.append(CHAR_POOL.charAt(rIndex));
        }
        return builder.toString();
    }
}