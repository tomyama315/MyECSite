package com.internousdev.template1.util;

import java.io.Console;

public class ConsoleAct {
	public void test(){
	Console console=System.console();
	String name=console.readLine();
	System.out.println("test:"+name);

	}
}
