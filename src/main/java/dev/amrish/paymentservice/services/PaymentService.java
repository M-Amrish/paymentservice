package dev.amrish.paymentservice.services;

import dev.amrish.paymentservice.services.paymentgateway.PaymentGatewaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewaySelector paymentGatewaySelector;

    public PaymentService(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }

    public String generatePaymentLink() {
        // write logic to add details in the database

        return paymentGatewaySelector.getPaymentGateway("razorpay").generatePaymentLink();
    }
}
