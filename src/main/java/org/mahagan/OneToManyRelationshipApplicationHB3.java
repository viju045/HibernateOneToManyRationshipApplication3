package org.mahagan;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.domain.Bank;
import org.mahagan.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class OneToManyRelationshipApplicationHB3 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction txs = session.beginTransaction();

    //Customer list of first Bank.

        Customer customer = new Customer();
        customer.setCustomerFirstName("vijay");
        customer.setCustomerLastName("Mohite");
        customer.setCustomerMobile("9087654321");

        Customer customer1 = new Customer();
        customer1.setCustomerFirstName("Sumit");
        customer1.setCustomerLastName("patil");
        customer1.setCustomerMobile("1234567890");

        Customer customer2 = new Customer();
        customer2.setCustomerFirstName("Ajay");
        customer2.setCustomerLastName("dhole");
        customer2.setCustomerMobile("543217890");

        List<Customer>list = new  ArrayList<>();
        list.add(customer);
        list.add(customer1);
        list.add(customer2);

        Bank bank = new Bank();
        bank.setBankName("BOI");

        bank.setCustomer(list);
        session.persist(bank);

        //Customer list of second Bank

        Customer customer3 = new Customer();
        customer3.setCustomerFirstName("Priya");
        customer3.setCustomerLastName("patil");
        customer3.setCustomerMobile("9870654378");

        Customer customer4 = new Customer();
        customer4.setCustomerFirstName("Seema");
        customer4.setCustomerLastName("Raje");
        customer4.setCustomerMobile("5478906123");

        Customer customer5 = new Customer();
        customer5.setCustomerFirstName("Riya");
        customer5.setCustomerLastName("Sharma");
        customer5.setCustomerMobile("7890654312");

        List<Customer>list1 = new  ArrayList<>();
        list1.add(customer3);
        list1.add(customer4);
        list1.add(customer5);

        Bank bank1 = new Bank();
        bank1.setBankName("HDFC");

        bank1.setCustomer(list1);
        session.persist(bank1);

        txs.commit();
        session.close();

        System.out.println("Data Successfully Inserted");

    }
}