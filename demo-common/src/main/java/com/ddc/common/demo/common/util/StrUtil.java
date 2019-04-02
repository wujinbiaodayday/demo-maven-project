package com.ddc.common.demo.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

public class StrUtil {

	private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f'};
	private static final char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	public static final Random random = new Random();
	public static final String emailReg = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	public static final String mobileReg = "^1[3-9]\\d{9}$";
	
	/**
	 * 将指定数字格式化为定长的字符串
	 * @param num
	 * @param length
	 * @return
	 */
	public static String formatNum(Number num, int length){
		String numStr = num.toString();
		while(numStr.length() < length){
			numStr = "0" + numStr;
		}
		return numStr;
	}

	/**
	 * <p>Description: 获取字符串</p>
	 * @author LongBing
	 * @date 2017年3月30日 下午3:57:48
	 */
	public static String getStringValueOf(Object obj) {
		if(obj == null)
			return null;
		if(obj instanceof Number){
			DecimalFormat format = new DecimalFormat("#");
			return format.format(obj);
		}
		String str = obj.toString().trim();
		if(str.equals("") || str.equals("null"))
			return null;
		return str;
	}
	
	/**
	 * <p>Description: 获取BigDecimal值</p>
	 * @author LongBing
	 * @date 2017年4月12日 下午4:38:23
	 */
	public static BigDecimal getBigDecimalValueOf(Object obj){
		if(obj == null)
			return null;
		if(obj instanceof Number){
			Number num = (Number) obj;
			return new BigDecimal(num.toString());
		}
		String str = obj.toString().trim();
		return new BigDecimal(str);
	}
	
	/**
	 * <p>Description: 获取指定长度随机字母串</p>
	 * @author LongBing
	 * @date 2017年5月24日 下午2:05:45
	 */
	public static String randomWord(int length){
		char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		while(length-- > 0){
			sb.append(letters[random.nextInt(26)]);
		}
		return sb.toString();
	}

	/**
	 * 随机指定长度的数字
	 *
	 * @param length
	 * @return
	 */
	public static String randomNumber(int length) {
		StringBuilder sb = new StringBuilder();
		for (int loop = 0; loop < length; ++loop) {
			sb.append(digits[random.nextInt(digits.length)]);
		}
		return sb.toString();
	}

}
