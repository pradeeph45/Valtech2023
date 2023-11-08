package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.service.EmployeeService;

class EmployeeServiceTest {
 private ApplicationContext appCtx;
 private DateFormat dateFormat;
	@BeforeEach
	void setUp() throws Exception {
	 appCtx=new ClassPathXmlApplicationContext("Tx3.xml");
	 dateFormat=new SimpleDateFormat("dd-MM-yyyy");
	}

	@AfterEach
	void tearDown() throws Exception {
	((AbstractApplicationContext) appCtx).close();
	}

	@Test
	void test() throws ParseException {
		Employee e=new Employee("Abc",dateFormat.parse("15-08-1947"),10000,'M',false);
		EmployeeService empSer=(EmployeeService)appCtx.getBean("EmployeeService");
		e=empSer.createEmployee(e);
		System.out.println(e);
		e=empSer.incrementSalary(e, 1000);
		System.out.println(e);
	}

}
