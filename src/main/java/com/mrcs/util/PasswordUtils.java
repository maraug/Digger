package com.mrcs.util;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {

	public static String digestPassword(String plainTextPassword) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(plainTextPassword.getBytes());
			byte[] bytes = md.digest();
			String sha256Password = new BigInteger(1, bytes).toString(16);
			return sha256Password;

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error encoding password", e);
		}
	}

}
