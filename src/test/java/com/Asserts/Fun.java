package com.Asserts;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Fun {
	static Logger log = LogManager.getLogger(Fun.class);
	public static void main(String[] args) {
		
		System.out.println("Hello");
		log.info("Kind Heart23");
		log.trace("Happens");
		
		// TestNG Assert
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(9, 10);
		
		asserts.assertNotEquals(10, 10);
		
		asserts.assertEquals(10, 11, "Not Equals");
		System.out.println("Good");
		asserts.assertEquals(10, 11, "Not Equals - 2");
		
		//Assert statement in java
		//assert 5>6: "False Statement";
		//assert 56==5;
		
		asserts.assertAll();
	}
}