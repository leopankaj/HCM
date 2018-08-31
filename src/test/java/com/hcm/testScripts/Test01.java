package com.hcm.testScripts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test01 {

	static int beforeCount = 1;
	static int afterCount = 1;

	public void test1() {

		System.out.println("Test1");

	}

	@Test
	public void test2() {

		System.out.println("Test2");

	}

	public void test3() {

		System.out.println("Test3");

	}

	@Test
	public void test4() {

		System.out.println("Test4");

	}

	public void test5() {

		System.out.println("Test5");

	}
	
	@Test
	public void test6() {

		System.out.println("Test6");

	}

	public void test7() {

		System.out.println("Test7");

	}


	public void test8() {

		System.out.println("Test8"+ afterCount++);

	}

	public void test9() {

		System.out.println("Test9");

	}

	public void test10() {

		System.out.println("Test10"+ beforeCount++);

	}

}
