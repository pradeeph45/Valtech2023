package com.valtech.training.springbootassignment.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.springbootassignment.component.ProductDAOImpl.ProductRowMapper;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	public class CustomerRowMapper implements RowMapper<Customer>{

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
           Customer c=new Customer();
           c.setCustomerId(rs.getInt(1));
           c.setCustomerName(rs.getString(2));
           c.setCustomerPhone(rs.getString(3));
           c.setCustomerAdddress(rs.getString(4));
			return c;
		}

	}
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void deleteCustomer(int id) {
		String deleteQry="DELETE FROM CUSTOMER WHERE CUSTOMER_ID=?";
		 new JdbcTemplate(dataSource).update(deleteQry,id);
	}
	@Override
	public void updateCustomer(Customer customer) {
		String queryUpdate="UPDATE CUSTOMER SET CUSTOMER_NAME = ? ,CUSTOMER_PHONE=?,CUSTOMER_ADDR=? WHERE CUSTOMER_ID=?";
		new JdbcTemplate(dataSource).update(queryUpdate,customer.getCustomerName(),customer.getCustomerPhone(),customer.getCustomerAdddress(),customer.getCustomerId());
	}
	
	@Override
	public void createCustomer(Customer customer) {
		String queryCreate="INSERT INTO CUSTOMER(CUSTOMER_NAME,CUSTOMER_PHONE,CUSTOMER_ADDR) VALUES(?,?,?)";
		new JdbcTemplate(dataSource).update(queryCreate,customer.getCustomerName(),customer.getCustomerPhone(),customer.getCustomerAdddress());
	}
	@Override
	public List<Customer> getAllCustomers(){
		String selectQry="SELECT CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_NAME,CUSTOMER_ADDR FROM CUSTOMER";
		return new JdbcTemplate(dataSource).query(selectQry, new CustomerRowMapper());
		
	}
	
	@Override
	public Customer getCustomer() {
		String selectQry="SELECT CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_PHONE,CUSTOMER_ADDR FROM CUSTOMER WHERE CUSTOMER_ID=?";
		return  new JdbcTemplate(dataSource).queryForObject(selectQry, new CustomerRowMapper());
	}
	@Override
	public long countProduct() {
		String countQry="SELECT COUNT(CUSTOMER_ID) FROM CUSTOMER";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
}
