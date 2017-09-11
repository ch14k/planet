package com.laotan.hotel.factory;

import java.util.ResourceBundle;

public class BeanFactory {
	private static ResourceBundle rb = null;
	static {
		rb = ResourceBundle.getBundle("instance");
	}

	public static <T> T getInstance(String key,Class<T> clazz){
		try {
			return  (T)Class.forName(rb.getString(key)).newInstance();
		} catch (Exception e) {
		 throw new RuntimeException(e);
		}  
	}
	
}
