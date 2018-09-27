package com.gmail.s.granovskiy;

public class Main {
	public static void main(String[] args) {
		Operations object = new Operations();
		object.printArray(object.splitText());
		object.getResponse(object.splitText());
	}
}