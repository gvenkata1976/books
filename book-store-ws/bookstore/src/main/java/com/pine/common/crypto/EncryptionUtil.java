package com.pine.common.crypto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
 
public class EncryptionUtil {
	
	private byte[] encryptionKey;
	private byte[] iV;

	public EncryptionUtil() {

		this.encryptionKey = new byte[] { 0x07, 0x00, 0x03, 0x00, 0x04, 0x00, 0x05, 0x02, 0x04, 0x00, 0x02, 0x0E, 0x02, 0x03, 0x02, 0x01, 0x07, 0x00, 0x04, 0x0F, 0x07, 0x00, 0x04, 0x0D };
		this.iV = new byte[] { 0x06, 0x08, 0x06, 0x05, 0x05, 0x05, 0x02, 0x0E };
	}

	public String encryptText(String plainText) throws Exception {
		// ---- Use specified 3DES key and IV from other source --------------
		byte[] plaintext = plainText.getBytes();

		Cipher c3des = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		SecretKeySpec myKey = new SecretKeySpec(encryptionKey, "DESede");
		IvParameterSpec ivspec = new IvParameterSpec(iV);

		c3des.init(Cipher.ENCRYPT_MODE, myKey, ivspec);
		byte[] cipherText = c3des.doFinal(plaintext);

		return new org.apache.commons.codec.binary.Base64().encodeAsString(cipherText);
	}

	public String decryptText(String cipherText) throws Exception {
		byte[] encData =  new org.apache.commons.codec.binary.Base64().decode(cipherText);
		Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
 
		SecretKeySpec myKey = new SecretKeySpec(this.encryptionKey, "DESede");
		IvParameterSpec ivspec = new IvParameterSpec(this.iV);
		decipher.init(Cipher.DECRYPT_MODE, myKey, ivspec);
		byte[] plainText = decipher.doFinal(encData);

		return new String(plainText);
	}

	public static void main(String args[]) throws Exception {

		EncryptionUtil t = new EncryptionUtil();
		String inputPassword = inputText();
		String cT = t.encryptText(inputPassword);
		System.out.println("Encrypted Password: " + cT);

		// Write the encrypted Password to a fie.
		try {
			// Create file
			FileWriter fstream = new FileWriter("encryptedPassword.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(cT);
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		//t.decryptText(cT);
		System.out.println("De-crypted Password: " + t.decryptText(cT));
	}

	public static String inputText() {

		// prompt the user to enter their String
		System.out.print("Enter your Password: ");

		// open up standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputString = null;
		// read the inputString from the command-line;
		// need to use try/catch with the readLine() method
		try {
			inputString = br.readLine();
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your name!");
			System.exit(1);
		}

		System.out.println("You entered: " + inputString);
		return inputString;
	}

}
