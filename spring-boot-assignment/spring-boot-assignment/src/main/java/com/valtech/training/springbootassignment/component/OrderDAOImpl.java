package com.valtech.training.springbootassignment.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.springbootassignment.component.CustomerDAOImpl.CustomerRowMapper;
@Component
public class OrderDAOImpl implements OrdersDAO {
	

	public class OrdersRowMapper implements RowMapper<Orders>{

		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
			Orders o=new Orders();
			o.setOrderId(rs.getInt(1));
			o.setCustomerId(rs.getInt(2));
			o.setOrderDate(rs.getDate(3));
			return o;
		}

	}
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	public void deleteOrders(int id) {
		String deleteQry="DELETE FROM CUSTOMER_ORDERS WHERE ORDER_ID=?";
		 new JdbcTemplate(dataSource).update(deleteQry,id);
	}
	
	@Override
	public void updateOrders(Orders orders) {
		String queryUpdate="UPDATE CUSTOMER_ORDERS SET CUSTOMER_ID = ? ,ORDER_DATE=? WHERE ORDER_ID=?";
		new JdbcTemplate(dataSource).update(queryUpdate,orders.getCustomerId(),orders.getOrderDate(),orders.getOrderId());
	}
	

	@Override
	public void createOrders(Orders orders) {
		String queryCreate="INSERT INTO CUSTOMER_ORDERS(CUSTOMER_ID,ORDER_DATE) VALUES(?,?)";
		new JdbcTemplate(dataSource).update(queryCreate,orders.getCustomerId(),orders.getOrderDate());
	}
	
	@Override
	public List<Orders> getOrders(){
		String selectQry="SELECT ORDER_ID,CUSTOMER_ID,ORDER_DATE FROM CUSTOMER_ORDERS";
		return new JdbcTemplate(dataSource).query(selectQry, new OrdersRowMapper());
		
	}
	
	@Override
	public Orders getOrder() {
		String selectQry="SELECT ORDER_ID,CUSTOMER_ID,ORDER_DATE FROM CUSTOMER_ORDERS WHERE ORDER_ID=?";
		return  new JdbcTemplate(dataSource).queryForObject(selectQry, new OrdersRowMapper());
	}

	@Override
	public long countOrders() {
		String countQry="SELECT COUNT(ORDER_ID) FROM CUSTOMER_ORDERS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
}


