package com.valtech.training.springbootassignment.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyDAOImpl implements CompanyDAO {
	@Override
	public String hello() {
		return "Hello";
	}
   public class CompanyRowMapper implements RowMapper<Company>{

	@Override
	public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company c=new Company();
        c.setCompanyId(rs.getInt(1));
        c.setCompanyName(rs.getString(2));
        c.setCompanyAddr(rs.getString(3));
		return c;
	}

	}

@Autowired
	private DataSource dataSource;
	
	@Override
	public void deleteCompany(int id) {
		String deleteQry="DELETE FROM COMPANY WHERE ID=?";
		 new JdbcTemplate(dataSource).update(deleteQry,id);
	}
	@Override
	public void updateCompany(Company company) {
		String queryUpdate="UPDATE COMPANY SET COMPANY_NAME = ? ,COMPANY_ADDR=? WHERE COMPANY_ID=?";
		new JdbcTemplate(dataSource).update(queryUpdate,company.getCompanyName(),company.getCompanyAddr(),company.getCompanyId());
	}
	
	@Override
	public void createCompany(Company company) {
		String queryCreate="INSERT INTO COMPANY(COMPANY_NAME,COMPANY_ADDR) VALUES(?,?)";
		new JdbcTemplate(dataSource).update(queryCreate,company.getCompanyName(),company.getCompanyAddr());
	}
	@Override
	public List<Company> getAllCompany(){
		String selectQry="SELECT COMPANY_ID,COMPANY_NAME,COMPANY_ADDR FROM COMPANY";
		return new JdbcTemplate(dataSource).query(selectQry, new CompanyRowMapper());
		
	}
	
	@Override
	public Company getCompany() {
		String selectQry="SELECT COMPANY_ID,COMPANY_NAME,COMPANY_ADDR FROM COMPANY WHERE COMPANY_ID=?";
		return (Company) new JdbcTemplate(dataSource).queryForObject(selectQry, new CompanyRowMapper());
	}
	@Override
	public long countCompany() {
		String countQry="SELECT COUNT(COMPANY_ID) FROM COMPANY";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}
}
