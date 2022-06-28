package com.supermarket.utilities;

import java.util.Random;

import org.openqa.selenium.WebDriver;

public class RandomNumberUtility {
	
	WebDriver driver;
	
	public RandomNumberUtility(WebDriver driver) {
		this.driver= driver;
	}

	public int randomNumber9Generator(int count) {
		long timeSeed = System.nanoTime();

		double randSeed = Math.random() * 1000;

		long midSeed = (long) (timeSeed * randSeed);

		String s = midSeed + "";
		String subStr = s.substring(0, count);

		int finalSeed = Integer.parseInt(subStr);

		return finalSeed;

	}
	
	public long generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	
}
