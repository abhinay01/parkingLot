package service;

import Model.Payment;
import Model.Ticket;

public class PaymentService {
    Payment payment;

    public Payment addPayment(String paymentId, Ticket ticket, String paymentChannel)
    {
        payment=new Payment(paymentId,ticket,paymentChannel);
        return payment;
    }
}
