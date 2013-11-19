package com.oreilly.springdata.mongodb.core;

import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: yhf
 * Date: 13-11-19
 * Time: 下午4:24
 * To change this template use File | Settings | File Templates.
 */
public class test {
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			prop.load(test.class.getClassLoader().getResourceAsStream("application.properties"));
			System.out.println(prop.getProperty("app.name"));
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}
}
