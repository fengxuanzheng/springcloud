package com.cloudproviderhystrixpayment8001.dao;


import com.cloudapicommons.pojo.Payment;

public interface PaymentDAO {

    public int create(Payment payment);
    public Payment getPaymentById( Long id);
}
