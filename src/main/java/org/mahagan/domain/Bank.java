package org.mahagan.domain;

import jakarta.persistence.*;

import java.util.List;
//This is My third OneToMany mapping relationship application.
@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long bankId;
    private String bankName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankId" )
    @OrderColumn(name = "type" )
    private List<Customer> customer;

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
