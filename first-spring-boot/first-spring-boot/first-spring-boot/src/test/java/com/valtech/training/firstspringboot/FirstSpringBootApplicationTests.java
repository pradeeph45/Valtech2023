package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.component.EmployeeDAO;
import com.valtech.training.firstspringboot.component.HelloWorld;
import com.valtech.training.firstspringboot.component.SimpleInterest;
import com.valtech.training.firstspringboot.entity.Order;
import com.valtech.training.firstspringboot.service.OrderService;

@SpringBootTest
class FirstSpringBootApplicationTests {
	
	@Autowired
	private HelloWorld helloWorld;
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Test
	void testSimpleInteresst() {
		simpleInterest.computeSimpleInterest(2000, 2, 3);
	}
	
	@Test
	void testEmployee() {
		assertEquals(5,employeeDAO.count());
	}
	@Test
	void testOrders() {
		Order o = orderService.createOrder(new Order("MacBook Pro m3",25,"For the Entire team",LocalDate.of(2023, 11, 8)));
		assertNotEquals(0, o.getId());
		assertTrue(orderService.getAllOrders().size()>0);
	}
	


}
