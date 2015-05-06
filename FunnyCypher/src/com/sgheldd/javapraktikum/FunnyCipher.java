package com.sgheldd.javapraktikum;

import java.util.Random;
import java.util.regex.Pattern;

/**Implements the FunnyCipher as specified in JavaPraktikum Übung 3 Aufgabe 3.
 *
 * Created by Georg on 25.04.2015.
 * (c) all tights reserved
 *
 * @author Georg Held
 */
public class FunnyCipher {

    /**
     * A usable alphabet for random character generation.
     */
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyzäüöABCDEFGHIJKLMNOPQRSTUVWXYZÄÜÖ!()$%&?:;., ";

    /**
     * Creates and seeds a ready made random number generator.
     */
    private final Random random = new Random(System.currentTimeMillis());

    /**
     * Encodes message with the FunnyCipher using key.
     *
     * @param key integer used to encrypt
     * @param message any string
     */
    public void encode(int key, String message) {
        StringBuffer data = new StringBuffer();

        for (int i = 0; i < key; i++) {
            data.append(this.nextRandomChar()).append('#').append(random.nextInt(100)).append('#');
        }

        for (char x : message.toCharArray()) {
            int jump;
            data.append(x).append('#').append(jump = random.nextInt(100)).append('#');

            for (int i = 0; i < jump; i++) {
                data.append(this.nextRandomChar()).append('#').append(random.nextInt(100)).append('#');
            }
        }
        System.out.println(data);
    }

    /**
     * Decodes a FunnyCipher encrypted cipherText using key.
     *
     * @param key integer used to encrypt
     * @param cipherText an encrypted message
     */
    public void decode(int key, String cipherText) {
        StringBuffer data = new StringBuffer();
        String[] stringList = cipherText.split(Pattern.quote("#"));
        for (int i = key * 2; i < stringList.length; i++) {
            data.append(stringList[i]);
            i += Integer.parseInt(stringList[i + 1]) * 2 + 1;
        }
        System.out.println(data);
    }

    /**
     * Finds a likely key for a FunnyCipher encrypted cipherText.
     * <p>
     * May not return the exact key used to encode the message, but a decoding with the returned key will probably
     * result in intelligible plaintext.
     *
     * @param cipherText an encrypted message
     * @return A likely key offset.
     */
    public int findKey(String cipherText) {
        String[] stringList = cipherText.split(Pattern.quote("#"));
        for (int key = 1; key < stringList.length; key += 2) {
            int i = key;
            while (i < stringList.length - 1) {
                i += Integer.parseInt(stringList[i]) * 2 + 2;

            }
            if (i + 1 == stringList.length) {
                return key / 2;
            }
        }
        return -1;
    }

    private char nextRandomChar() {
        return ALPHABET.charAt(random.nextInt(ALPHABET.length()));
    }

}
