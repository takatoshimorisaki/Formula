package mori.util;

import static java.lang.System.out;

public class NumericChecker {

	public boolean mExe(String token){
		
		char charValue = token.charAt(0);
		
		if(charValue >= '0' && charValue <= '9'){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		
		NumericChecker nc = new NumericChecker();
		
		boolean ans = nc.mExe("0");
		
		out.println(ans);
		
		ans = nc.mExe("1");

		out.println(ans);
		
		nc.mExe("2");
		nc.mExe("3");
		nc.mExe("4");
		nc.mExe("5");
		nc.mExe("6");
		nc.mExe("7");
		nc.mExe("8");
		nc.mExe("9");
		ans = nc.mExe("A");

		out.println(ans);
	}
}
