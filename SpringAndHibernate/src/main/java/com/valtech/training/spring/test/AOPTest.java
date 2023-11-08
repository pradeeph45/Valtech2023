package com.valtech.training.spring.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.Arithmetic;
import com.valtech.training.spring.DivideByZeroException;

class AOPTest {
	private ApplicationContext appCts;

	@BeforeEach
	void initialize() {
		appCts = new ClassPathXmlApplicationContext("AOP.xml");
	}
	
	@AfterEach
	void closeAll() {
		((AbstractApplicationContext) appCts).close();
	}

	@Test
	void test() {
     Arithmetic arith=(Arithmetic)appCts.getBean(Arithmetic.class);
     System.out.println(arith.getClass().getName());
    // System.out.println(arith);
     assertEquals(5,arith.add(2, 3));
     assertEquals(-2,arith.sub(4, 6));
     assertEquals(3,arith.add(2, 1));
     assertEquals(1,arith.sub(3, 2));
     try {
     arith.div(5, 0);
     fail("No Exception Occuered");
     }
     catch(Exception e) {
    	 
     }
	}

}
