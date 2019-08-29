package util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Hex;

public class PBKDF2PasswordHash {
	public String hashPassword(String password) {
	    String salt = "akfo~@293--";
	    int iterations = 10000;
	    int keyLength = 512;
	    char[] passwordChars = password.toCharArray();
	    byte[] saltBytes = salt.getBytes();
		byte[] hashedBytes;
	    String hashedString = "";
			try {
				hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
				hashedString = Hex.encodeHexString(hashedBytes);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		return hashedString;
	}

	public static byte[] hashPassword( final char[] password, final byte[] salt, final int iterations, final int keyLength ) throws NoSuchAlgorithmException {
	
	 try {
	     SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
	     PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
	     SecretKey key = skf.generateSecret( spec );
	     byte[] res = key.getEncoded( );
	     return res;
		 } catch ( InvalidKeySpecException e ) {
		     throw new RuntimeException( e );
		 }
	}
}
