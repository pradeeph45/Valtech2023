package com.valtech.training.hibernate.client;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.Company;
import com.valtech.training.hibernate.ProductOrder;
import com.valtech.training.hibernate.Product;
import com.valtech.training.hibernate.ProductCustomer;

public class HibernateClient {
    
	public static void main(String[] args) throws HibernateException, ParseException{
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
     AnnotationConfiguration cfg=new AnnotationConfiguration();
//     cfg.addAnnotatedClass(Employee.class);
//     cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(ATMTx.class);
//     cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).addAnnotatedClass(Account.class);
//     cfg.addAnnotatedClass(Registration.class);
//     cfg.addAnnotatedClass(BankAccount.class);
      cfg.addAnnotatedClass(Company.class).addAnnotatedClass(Product.class).addAnnotatedClass(ProductCustomer.class).addAnnotatedClass(ProductOrder.class);
     SessionFactory sessFac=cfg.buildSessionFactory();
     Session ses= (Session) sessFac.openSession();
     Transaction tx=(Transaction) ( (org.hibernate.Session) ses).beginTransaction();
     
     
    Company c=new Company("Valtech","JP Nagar");
    Product p1=new Product("Software",12324);
    Product p2=new Product("Hardware",12324);
    ses.save(c);
    ses.save(p1);
    ses.save(p2);
    c.addProduct(p1);
    c.addProduct(p2);
     
     
     ProductCustomer pc=new ProductCustomer("Pradeep","1224211","Raichur");
     ses.save(pc);
     ProductOrder po1=new ProductOrder(df.parse("12-12-2023"));
     ProductOrder po2=new ProductOrder(df.parse("11-12-2023"));
     ses.save(po1);
     ses.save(po2);
     pc.addProductOrder(po1);
     pc.addProductOrder(po2);
         
//     RegAddress regAdd=new RegAddress("5th cross","Blr","12243");
//     Registration reg=new Registration("pradeep","112",123456,regAdd);
//     ses.save(reg);
//     
//     
//     ses.persist(new BankAccount(new BankAccountId("SB",1),30000));
//     
//     BankAccountId id=new BankAccountId("SB",1);
//     BankAccount b=(BankAccount) ses.load(BankAccountId.class, id);
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
     
     ses.createQuery("from Company c").list().forEach(t -> System.out.println(t));
     ses.createQuery("from ProductCustomer c").list().forEach(t -> System.out.println(t));
     tx.commit();
     ses.close();
     sessFac.close();
     
	}

}
