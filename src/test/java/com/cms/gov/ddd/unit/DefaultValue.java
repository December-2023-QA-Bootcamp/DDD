package com.cms.gov.ddd.unit;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class DefaultValue {

	static char a = 'l';
	static String string;
	
	
	@Test
	public void defaultValueTest() {
		System.err.println((int)a);
		
		// 127 - 128
		@SuppressWarnings("unused")
		byte b = -128;
		//32767 - 32768
		@SuppressWarnings("unused")
		short s = -32768;
		
		System.err.println(string);
	}
}
