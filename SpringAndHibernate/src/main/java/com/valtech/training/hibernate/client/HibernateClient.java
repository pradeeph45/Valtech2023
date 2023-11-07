package com.valtech.training.hibernate.client;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.ATMTx;
import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.RegAddress;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {
    
	public static void main(String[] args) throws HibernateException, ParseException{
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
     AnnotationConfiguration cfg=new AnnotationConfiguration();
     cfg.addAnnotatedClass(Employee.class);
     cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(ATMTx.class);
     cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).addAnnotatedClass(Account.class);
     cfg.addAnnotatedClass(Registration.class);
     cfg.addAnnotatedClass(BankAccount.class);
     SessionFactory sessFac=cfg.buildSessionFactory();
     Session ses= (Session) sessFac.openSession();
     Transaction tx=(Transaction) ( (org.hibernate.Session) ses).beginTransaction();
     
    
     RegAddress regAdd=new RegAddress("5th cross","Blr","12243");
     Registration reg=new Registration("pradeep","112",123456,regAdd);
     ses.save(reg);
     
     
     ses.persist(new BankAccount(new BankAccountId("SB",1),30000));
     
     BankAccountId id=new BankAccountId("SB",1);
     BankAccount b=(BankAccount) ses.load(BankAccountId.class, id);
//     Customer cus=new Customer("Abc",23);
//     ses.save(cus);
//     Address add=new Address("JP Nagar","Blr",560071);
//     add.setCustomer(cus);
//     cus.setAddress(add);
//     ses.save(add);
//     
//     Account acc=new Account(10000,"SB");
//     Tx tx1=new Tx(1000);
//     Tx tx2=new ChequeTx(2000,1232,1342);
//     Tx tx3=new TellerTx(3000,123,123);
//     Tx tx4=new ATMTx(5000,700);
//     
//     ses.persist(acc);
//     ses.persist(tx1);
//     ses.persist(tx2);
//     ses.persist(tx3);
//     ses.persist(tx4);
//     acc.addTx(tx1);
//     acc.addTx(tx2);
//     acc.addTx(tx3);
//     acc.addTx(tx4);
//     ses.createQuery("from Tx tx").list().forEach(t-> System.out.println(t));
//     org.hibernate.Query query=ses.createQuery("SELECT DISTINCT c from Customer c JOIN c.accounts a join a.txs t where t.amount>?");  
//     query.setFloat(0,3000);
//     query.list().forEach(t-> System.out.println(t));
       //Query query=ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
//      query.setString(0, "Blr");
//      query.setFloat(1, 3000);
       //query.list().forEach(t-> System.out.println(t));
//     ses.save(new Tx(1000));
//     ses.save(new ChequeTx(2000,123123,34435));
//     ses.save(new TellerTx(2000,12324,132442));
//     ses.save(new ATMTx(2000,1232));
//     ses.createQuery("from Tx tx").list().forEach(t-> System.out.println(t));
    // ((org.hibernate.Session) ses).persist(new Employee("Abc",df.parse("15-08-1947"),20000,'M',false));
     
     
     
     tx.commit();
     ses.close();
     sessFac.close();
     
	}

}
