package com.siml.shop;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Encryptor {
	public static void main(String[] args) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("SIML");
		
		String url = encryptor.encrypt("jdbc:mysql://localhost:3306/test?useSSL=false&amp;autoReconnect=true&amp;serverTimezone=UTC");
		String username = encryptor.encrypt("root");
		String password = encryptor.encrypt("123456");
		String mailID = encryptor.encrypt("simlshopmaster@gmail.com");
		String mailPwd = encryptor.encrypt("simlshop!1");
		
		System.out.println("url = " + url);
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		System.out.println("mailID = " + mailID);
		System.out.println("mailPwd = " + mailPwd);
	}
}
