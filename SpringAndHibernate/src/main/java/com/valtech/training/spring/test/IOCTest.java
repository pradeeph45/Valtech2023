package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.HelloWorld;
import com.valtech.training.spring.Line;
import com.valtech.training.spring.SimpleInterest;
import com.valtech.training.spring.UtilsBean;

class IOCTest {
	
	private  ApplicationContext appCts;
	private ApplicationContext childAppCtx;
@BeforeEach
void initialize() {
	appCts=new ClassPathXmlApplicationContext("ioc.xml");
	childAppCtx=new ClassPathXmlApplicationContext(new String[]{"IOC-child.xml"},appCts);
}

@Test 
void testChildAppCtx() {
	Line l=(Line)childAppCtx.getBean("l1");
	System.out.println(l);
}

@Test
void testUtils() {
	UtilsBean ub=(UtilsBean)appCts.getBean(UtilsBean.class);
	System.out.println(ub.getNames());
	System.out.println(ub.getSettings());
	System.out.println(ub.getPoints());
}

  @Test
  void testSimpleInterest() {
	  SimpleInterest si=(SimpleInterest) appCts.getBean(SimpleInterest.class);
	  System.out.println(si.computeSimpleInterest(3000, 12, 5));
  }

   @Test
   void testPointSetterInjection() {
	   System.out.println(appCts.getBean("p2"));
   }

	@Test
	void test() {
    
     HelloWorld hw=(HelloWorld) appCts.getBean("hw");
     assertEquals("Hello World",hw.hello("World"));
     assertEquals(appCts.getBean("hw"),appCts.getBean("abc"));
	}

	
	@Test
	void testPoint() {
		System.out.println(appCts.getBean("p1"));
		assertEquals(appCts.getBean("p1"),appCts.getBean("p1"));
	}
	
	@Test
	void testLine() {
		System.out.println(appCts.getBean("l2"));
	}
}
