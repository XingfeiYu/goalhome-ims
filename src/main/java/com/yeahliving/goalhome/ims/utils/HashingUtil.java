package com.yeahliving.goalhome.ims.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class HashingUtil {
    private enum Algorithm {
        MD5("MD5");

        Algorithm(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        private final String value;
    }

    public enum Encoding {
        UTF8("UTF-8");

        Encoding(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        private final String value;
    }

    /**
     * Create an MD5 hash value.
     * @param source	The string to be hashed.
     * @param encoding	The encoding to use for hashing.
     * @return			The resulting numeric hash value, or null of the source string is null.
     */
    public static Long encodeMD5(String source, Encoding encoding) {
        if (source == null) {
            return null;
        }

        byte[] digested = digest(source, Algorithm.MD5.toString(), encoding);

        return new BigInteger(digested).longValue();
    }

    /**
     * Create an MD5 hash value.
     * @param source	The string to be hashed.
     * @return			The resulting numeric hash value, or null of the source string is null.
     */
    public static Long encodeMD5(String source) {
        return encodeMD5(source, null);
    }

    /**
     * Perform the source digestion.
     * @param source	The source input to be digested.
     * @param algorithm	The hashing algorithm to be used.  Assumed to be valid.
     * @param encoding	The byte encoding to be used for the source.  If null, uses default Java encoding.
     * @return			A bite array representing the digested hash.
     */
    private static byte[] digest(String source, String algorithm, Encoding encoding) {
        MessageDigest digester;

        try {
            digester = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        byte[] digest;
        try {
            if (encoding == null) {
                digest = digester.digest(source.getBytes());
            } else {
                digest = digester.digest(source.getBytes(encoding.toString()));
            }
        } catch (UnsupportedEncodingException e) {
            return null;
        }

        return digest;
    }

}
