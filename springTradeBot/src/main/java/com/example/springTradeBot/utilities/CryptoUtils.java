package com.example.springTradeBot.utilities;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CryptoUtils {

	public static final String AES = "AES";

	@Value("${encryptKey}")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	private byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}

	public String encrypt(String message) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		byte[] bytekey = hexStringToByteArray(key);
		SecretKeySpec sks = new SecretKeySpec(bytekey, AES);
		Cipher cipher = Cipher.getInstance(AES);
		cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
		byte[] encryptedByte = cipher.doFinal(message.getBytes());
		return byteArrayToHexString(encryptedByte);

	}

	public String decrypt(String encryptedMessage) {
		byte[] bytekey = hexStringToByteArray(key);
		SecretKeySpec sks = new SecretKeySpec(bytekey, AES);
		byte[] decrypted = null;
		try {
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.DECRYPT_MODE, sks);
			decrypted = cipher.doFinal(hexStringToByteArray(encryptedMessage));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String decryptedMessage = new String(decrypted);
		return decryptedMessage;

	}
}
