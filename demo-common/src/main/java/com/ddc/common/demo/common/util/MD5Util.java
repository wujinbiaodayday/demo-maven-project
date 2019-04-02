package com.ddc.common.demo.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String md5(String string) {  
        byte[] hash;  
        try {  
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("utf8"));  
        } catch (NoSuchAlgorithmException e) {  
            throw new RuntimeException("Huh, MD5 should be supported?", e);  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);  
        }  
  
        StringBuilder hex = new StringBuilder(hash.length * 2);  
        for (byte b : hash) {  
            if ((b & 0xFF) < 0x10) hex.append("0");  
            hex.append(Integer.toHexString(b & 0xFF));  
        }  
        return hex.toString();  
    }

	public static void main(String[] args) {
		System.out.println(MD5("758745"));
	}
}
