package com.yc.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 鍔犲瘑宸ュ叿绫�
 * md5鍔犲瘑鍑烘潵鐨勯暱搴︽槸32浣�
 * sha鍔犲瘑鍑烘潵鐨勯暱搴︽槸40浣�
 */
public class Encrypt {

	/**
	 * 娴嬭瘯:   褰╄櫣琛�
	 */
	public static void main(String[] args) {
		// md5鍔犲瘑娴嬭瘯
		String md5_1 =md5( md5("a"));
		String md5_2 = md5("abc");
		System.out.println(md5_1 + "\n" + md5_2);
		// sha鍔犲瘑娴嬭瘯
		String sha_1 = sha("123456");
		String sha_2 = sha("abc");
		System.out.println(sha_1 + "\n" + sha_2);

	}

	/**
	 * 鍔犲瘑
	 * 
	 * @param inputText
	 * @return
	 */
	public static String e(String inputText) {
		return md5(inputText);
	}

	/**
	 * 浜屾鍔犲瘑锛屽簲璇ョ牬瑙ｄ笉浜嗕簡鍚э紵
	 * @param inputText
	 * @return
	 */
	public static String md5AndSha(String inputText) {
		return sha(md5(inputText));
	}

	/**
	 * md5鍔犲瘑
	 * @param inputText
	 * @return
	 */
	public static String md5(String inputText) {
		return encrypt(inputText, "md5");
	}

	/**
	 * sha鍔犲瘑
	 * @param inputText
	 * @return
	 */
	public static String sha(String inputText) {
		return encrypt(inputText, "sha-1");
	}

	/**
	 * md5鎴栬�卻ha-1鍔犲瘑
	 * 
	 * @param inputText
	 *            瑕佸姞瀵嗙殑鍐呭
	 * @param algorithmName
	 *            鍔犲瘑绠楁硶鍚嶇О锛歮d5鎴栬�卻ha-1锛屼笉鍖哄垎澶у皬鍐�
	 * @return
	 */
	private static String encrypt(String inputText, String algorithmName) {
		if (inputText == null || "".equals(inputText.trim())) {
			throw new IllegalArgumentException("璇疯緭鍏ヨ鍔犲瘑鐨勫唴瀹�");
		}
		if (algorithmName == null || "".equals(algorithmName.trim())) {
			algorithmName = "md5";
		}
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance(algorithmName);
			m.update(inputText.getBytes("UTF8"));
			byte s[] = m.digest();
			// m.digest(inputText.getBytes("UTF8"));
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptText;
	}

	/**
	 * 杩斿洖鍗佸叚杩涘埗瀛楃涓�
	 * 
	 * @param arr
	 * @return
	 */
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}
	
	 

}
