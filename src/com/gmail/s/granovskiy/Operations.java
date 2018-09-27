package com.gmail.s.granovskiy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Operations implements Interface {
    
	public void getResponse(String[] arrayOne) {
		String s = null;
		for (String string : arrayOne) {
			
			try {
				s = "\"" + string + "\"";
				URL url = new URL(s);   //  creating new object
				HttpURLConnection urlc = (HttpURLConnection) url.openConnection();  //  creating HttpURLConnection
				
				System.out.println("Method of request to server: " + urlc.getRequestMethod());
				System.out.println("Type of response: " + urlc.getResponseMessage());
				System.out.println(urlc.getHeaderField(0));

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
	
	public void printArray(String[] array) {
		for (String string : array) {
			System.out.println(string);
		}
	}
	
	public String[] splitText() {
		String englishText = loadFromFile(new File("test.txt"));
		String[] arrayOne = englishText.split(" ");
		return arrayOne;
	}
	
	public String loadFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}

}
