package com.cloudproviderpaymentForZookeeper8004.dao;


import com.cloudapicommons.pojo.Payment;

public interface PaymentDAO {

    public int create(Payment payment);
    public Payment getPaymentById( Long id);
}
