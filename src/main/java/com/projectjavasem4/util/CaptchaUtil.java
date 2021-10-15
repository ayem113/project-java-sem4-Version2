package com.projectjavasem4.util;

import java.util.Random;

public class CaptchaUtil {
	public static String randomText1() 	 {
		int number=new Random().nextInt(); 
		return Integer.toHexString(number);	 
	}


	public static String randomText2(int captchaLength) 	 {
		String saltChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer captchaStrBuffer = new StringBuffer();
		java.util.Random rnd = new java.util.Random();

		// build a random captchaLength chars salt        
		while (captchaStrBuffer.length() < captchaLength){
			int index = (int) (rnd.nextFloat() * saltChars.length());
			captchaStrBuffer.append(saltChars.substring(index, index+1));
		}

		return captchaStrBuffer.toString();
	}
}
