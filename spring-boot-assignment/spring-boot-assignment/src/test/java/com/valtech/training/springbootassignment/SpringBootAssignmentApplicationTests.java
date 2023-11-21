package com.valtech.training.springbootassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.springbootassignment.component.*;
import com.valtech.training.springbootassignment.controller.HelloController;
import com.valtech.training.springbootassignment.entities.Employee;
import com.valtech.training.springbootassignment.services.DepartmentService;
import com.valtech.training.springbootassignment.services.EmployeeService;

@SpringBootTest
class SpringBootAssignmentApplicationTests {
//    @Autowired
//    private HelloController helloController;
//	@Test
//	void contextLoads() {
//		assertEquals("index", helloController.hello());
//	}
//    @Autowired
//	private CompanyDAO companyDAO;
//    
//    @Test
//    void testCompany() {
//   	companyDAO.createCompany(new Company("Valtech Mobility","Pune"));
//
//    }
//    
//    @Autowired
//    private ProductDAO productDAO;
//    
//    @Test
//    void testProduct() {
////    	productDAO.createProduct(new Product("Software",1,1234.45));
////    	productDAO.createProduct(new Product("LV",1,1234231.45));
//    	assertEquals(2,productDAO.countProduct());
//    }
//    
//    @Autowired
//    private CustomerDAO customerDAO;
//    
//    @Test
//    void testCustomer() {
//    	//customerDAO.createCustomer(new Customer("Pradeep","123456789","TilakNagar"));
//    	customerDAO.createCustomer(new Customer("Virat","1234223412","Jayanagar"));
//    	//customerDAO.deleteCustomer(3);
//    	//assertEquals(2, customerDAO.countProduct());
//    }
//    DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
//    @Autowired
//    private OrdersDAO orders;
//    
//    @Test
//    void testOrders() throws ParseException {
//    	orders.createOrders(new Orders(1,df.parse("12-11-2023")));
//    }
	
//	@Autowired 
//	private EmployeeService employeeService;
//	
//	@Test
//	void testEmployee() {
//	}
	
	@Autowired
	private DepartmentService departmentService;
	@Test
	void testDepartment() {
		
	}
}
