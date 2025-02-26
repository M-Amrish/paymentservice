package dev.amrish.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelector {

    private RazorpayGateway razorpayGateway;
    private StripeGatway stripeGatway;

    PaymentGatewaySelector(RazorpayGateway razorpayGateway, StripeGatway stripeGatway) {
        this.razorpayGateway = razorpayGateway;
        this.stripeGatway = stripeGatway;
    }
    public PaymentGateway getPaymentGateway(String gateway) {
        if (gateway.equals("razorpay")) {
            return razorpayGateway;
        }
        return stripeGatway;
    }

}
