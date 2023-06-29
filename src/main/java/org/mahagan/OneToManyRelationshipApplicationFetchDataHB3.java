package org.mahagan;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.domain.Bank;
import org.mahagan.domain.Customer;

import java.util.Iterator;
import java.util.List;

public class OneToManyRelationshipApplicationFetchDataHB3 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction txs = session.beginTransaction();

        TypedQuery query = session.createQuery("From Bank bank");

        List<Bank>list = query.getResultList();
        Iterator<Bank>iterator = list.listIterator();

        while(iterator.hasNext())
        {
            Bank bank1 = iterator.next();
            System.out.println(bank1.getBankName());

            List<Customer>list1 = bank1.getCustomer();
            Iterator<Customer>iterator1 = list1.listIterator();
            while(iterator1.hasNext())
            {
                Customer customer = iterator1.next();
                System.out.println(customer.getCustomerFirstName()+ "-"+customer.getCustomerLastName()+"-"+customer.getCustomerMobile() );
            }
        }
        session.close();
        System.out.println("Data Fetch Successfully");
    }
}
