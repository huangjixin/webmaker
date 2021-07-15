package com.hjx.webmaker.parent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class ParentApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher("APP9e3536");
		boolean res = m.find();
		System.out.println(res);
	}
}
