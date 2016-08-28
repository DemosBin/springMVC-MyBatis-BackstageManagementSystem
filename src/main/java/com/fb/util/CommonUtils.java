package com.fb.util;

import java.util.List;

public class CommonUtils {
	
	public static boolean isEmpty( List<?> list ){
		return list == null || list.size() == 0 ;
	}
	
	public static boolean isEmpty( String str ){
		return str == null || str.trim().equals("") ;
	}
}
