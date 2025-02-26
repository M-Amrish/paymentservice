package dev.amrish.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class StripeGatway implements PaymentGateway {
    @Override
    public String generatePaymentLink() {
        return "";
    }
}
