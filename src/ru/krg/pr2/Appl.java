package ru.krg.pr2;

import java.io.*;
//import java.lang.Thread;
import ru.krg.pr2.util.Life;

public class Appl {
	private byte widthArea = 40;
	private byte heightArea = 10;
	public static void main(String[] args){
		System.out.println("START");
		Life life = new Life();
		life.run();
		System.out.println("\nEND");
	}
}
