package com.internousdev.template1.util;

public class InputException extends Exception{
	private int i;
	private String str;
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
