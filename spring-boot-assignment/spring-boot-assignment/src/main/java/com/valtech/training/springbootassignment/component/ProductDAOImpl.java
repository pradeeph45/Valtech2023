package com.valtech.training.springbootassignment.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.springbootassignment.component.CompanyDAOImpl.CompanyRowMapper;

@Component
public class ProductDAOImpl implements ProductDAO {

	public class ProductRowMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
         Product p=new Product();
         p.setProductId(rs.getInt(1));
         p.setProductName(rs.getString(2));
         p.setManufacturerId(rs.getInt(3));
         p.setProductAmt(rs.getDouble(4));
			return p;
		}

	}
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void deleteProduct(int id) {
		String deleteQry="DELETE FROM PRODUCT WHERE PRODUCT_ID=?";
		 new JdbcTemplate(dataSource).update(deleteQry,id);
	}
	@Override
	public void updateProduct(Product product) {
		String queryUpdate="UPDATE PRODUCT SET PRODUCT_NAME = ? ,MANUFACTURER_ID=?,PRODUCT_AMT=? WHERE PRODUCT_ID=?";
		new JdbcTemplate(dataSource).update(queryUpdate,product.getProductName(),product.getManufacturerId(),product.getProductAmt(),product.getProductId());
	}
	
	@Override
	public void createProduct(Product product) {
		String queryCreate="INSERT INTO PRODUCT(PRODUCT_NAME,MANUFACTURER_ID,PRODUCT_AMT) VALUES(?,?,?)";
		new JdbcTemplate(dataSource).update(queryCreate,product.getProductName(),product.getManufacturerId(),product.getProductAmt());
	}
	@Override
	public List<Product> getAllProducts(){
		String selectQry="SELECT PRODUCT_ID,PRODUCT_NAME,MANUFACTURER_ID,PRODUCT_AMT FROM PRODUCT";
		return new JdbcTemplate(dataSource).query(selectQry, new ProductRowMapper());
		
	}
	
	@Override
	public Product getProduct() {
		String selectQry="SELECT PRODUCT_ID,PRODUCT_NAME,MANUFACTURER_ID,PRODUCT_AMT FROM PRODUCT WHERE PRODUCT_ID=?";
		return  new JdbcTemplate(dataSource).queryForObject(selectQry, new ProductRowMapper());
	}
	@Override
	public long countProduct() {
		String countQry="SELECT COUNT(PRODUCT_ID) FROM PRODUCT";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
}
