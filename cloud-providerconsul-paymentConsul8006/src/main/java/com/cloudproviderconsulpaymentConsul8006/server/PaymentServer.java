package com.cloudproviderconsulpaymentConsul8006.server;

import com.cloudapicommons.pojo.Payment;
import com.cloudproviderconsulpaymentConsul8006.dao.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServer {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PaymentDAO paymentDAO;

    public int create(Payment payment)
    {
       return paymentDAO.create(payment);
    }

    public Payment selectPaymentById(Long id)
    {
       return paymentDAO.getPaymentById(id);
    }
}
